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

	constructor(private router: Router, private authService: AuthService) { }

	public logout() {
		this.authService.logout();
	}

	get authenticated() : boolean {
		return this.authService.authenticated;
	}
}
