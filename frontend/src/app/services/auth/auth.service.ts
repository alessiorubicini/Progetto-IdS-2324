import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from 'src/environments/environment';
import {JwtHelperService} from '@auth0/angular-jwt';
import {catchError, Observable, tap, throwError} from 'rxjs';
import {User} from "../../models/user";
import {Router} from "@angular/router";
import {Role} from "../../models/role";


@Injectable({
	providedIn: 'root'
})
export class AuthService {

	constructor(private httpClient: HttpClient, private router: Router, private jwtHelper: JwtHelperService) {}

	public login(credentials: { username: string; password: string }): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/auth/login`, credentials, {observe: 'response'})
			.pipe(tap((response: any) => {
					const authToken = this.extractAuthToken(response.headers);
					if (authToken) {
						this.storeToken(authToken);
					}
					const userInfo = JSON.stringify(response.body);
					localStorage.setItem("user_info", userInfo);

				}),
				catchError(error => {
					console.error('Login failed. Error:', error);
					return throwError(() => error);
				})
			);
	}

	public signup(user: User): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/auth/signup`, user, {observe: 'response'})
			.pipe(tap((response: any) => {
					if(response.statusCode === 200) {
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

	}

	public isAuthenticated(): boolean {
		const token = localStorage.getItem('access_token');
		return token != null && !this.jwtHelper.isTokenExpired(token);
	}

	public getUserRole() : Role | null {
		const userInfo = localStorage.getItem("user-info");
		if(userInfo) return JSON.parse(userInfo);
		return null;
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
}
