import {Component} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from "./services/auth/auth.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';
  	authenticated: boolean = false;

	constructor(private router: Router, private authService: AuthService) {
		this.authenticated = authService.isAuthenticated();
	}

	public logout() {
		this.authService.logout();
	}

}
