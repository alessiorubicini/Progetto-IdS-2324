import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from 'src/environments/environment';
import {JwtHelperService} from '@auth0/angular-jwt';
import {Observable, catchError, tap, throwError} from 'rxjs';
import {User} from "../../models/user";
import {Router} from "@angular/router";

@Injectable({
	providedIn: 'root'
})
export class AuthService {

	constructor(private httpClient: HttpClient, private router: Router, private jwtHelper: JwtHelperService) {}

	public login(credentials: { username: string; password: string }): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/auth/login`, credentials, {observe: 'response'})
			.pipe(tap((response: any) => {
					//localStorage.setItem("user-data", response.body);
					const authToken = this.extractAuthToken(response.headers);
					if (authToken) {
						this.storeToken(authToken);
					}
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
	}

	public isAuthenticated(): boolean {
		// Check if the token is expired or valid
		const token = localStorage.getItem('access_token');
		return !this.jwtHelper.isTokenExpired(token);
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
