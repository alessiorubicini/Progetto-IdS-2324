import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';
  	token: string | null;

	constructor(private router: Router) {
		this.token = this.getToken();
	}

	getToken(): string | null {
		return localStorage.getItem("access_token");
	}

	public logout() {
		localStorage.removeItem("access_token");
		this.router.navigate(['/home']);
	}

}
