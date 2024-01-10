import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {environment} from 'src/environments/environment';
import {JwtHelperService} from '@auth0/angular-jwt';
import {catchError, Observable, tap, throwError} from 'rxjs';
import {User} from "../../models/user";
import {Router} from "@angular/router";
import {UserInfo} from "../../models/user-info";
import {Role} from "../../models/role";

@Injectable({
	providedIn: 'root'
})
export class AuthService {
	public authenticated: boolean = false;

	constructor(private httpClient: HttpClient, private router: Router, private jwtHelper: JwtHelperService) {
		const token = localStorage.getItem('access_token');
		if(token != null && !this.jwtHelper.isTokenExpired(token)) {
			this.authenticated = true;
		} else {
			this.authenticated = false;
		}
	}

	public login(credentials: { username: string; password: string }): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/auth/login`, credentials, {observe: 'response'})
			.pipe(tap((response: HttpResponse<any>) => {
					const authToken = this.extractAuthToken(response.headers);
					if (authToken) {
						this.storeToken(authToken);
					}
					const userInfo = JSON.stringify(response.body);
					localStorage.setItem("user-info", userInfo);
					this.authenticated = true;
				}),
				catchError(error => {
					console.error('Login failed. Error:', error);
					return throwError(() => error);
				})
			);
	}

	public signup(user: User): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/auth/signup`, user, {observe: 'response'})
			.pipe(tap((response: HttpResponse<any>) => {
					if(response.status === 200) {
						this.router.navigate(['/login']);
					}
				}),
				catchError(error => {
					console.error('Signup failed. Error:', error);
					return throwError(() => error);
				})
			);
	}

	public logout(): void {
		localStorage.removeItem("access_token");
		localStorage.removeItem("user_info")
		this.router.navigate(['/home']);
		this.authenticated = false;
	}

	public getUserInfo() : UserInfo | null {
		const userInfo = localStorage.getItem("user-info");
		return JSON.parse(userInfo!);
	}

	private storeToken(token: string): void {
		localStorage.setItem('access_token', token);
	}

	private extractAuthToken(headers: HttpHeaders): string | null {
		const authHeader = headers.get('Authorization');
		if (authHeader && authHeader.startsWith('Bearer ')) {
			return authHeader.substring(7); // Remove "Bearer " part
		}
		return null;
	}

	public userRoleForCity(id: number) : Role | undefined {
		const info = this.getUserInfo();
		return info?.roles.find(r => r.city.id == id)?.role;
	}
}
