import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable, catchError, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

	constructor(private httpClient: HttpClient, private jwtHelper: JwtHelperService) { }

	public login(credentials: { username: string; password: string }): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/api/auth/login`, credentials)
		.pipe(tap((response: any) => {
			  // TODO: spostare gestione token negli header della risposta
			  console.log('Login successful. Response:', response);
			  if (response) {	
				localStorage.setItem('access_token', response);
			  }
			  return response;
			})
		  );
		  // TODO: Aggiungere gestione errori
	}

	public signup(): void {
		// TODO: implementare registrazione utente
	}

	public logout() : void {
		localStorage.removeItem("access_token");
	}

	public isAuthenticated(): boolean {
		// Check if the token is expired or valid
		const token = localStorage.getItem('access_token');
		return !this.jwtHelper.isTokenExpired(token);
	}
}
