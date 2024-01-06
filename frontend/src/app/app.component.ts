import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from "./services/auth/auth.service";
import {ToastrService} from 'ngx-toastr';
import {Title} from "@angular/platform-browser";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';

	constructor(private router: Router, private authService: AuthService, private toastrService: ToastrService, private titleService: Title) {
		this.titleService.setTitle("OpenCity");
	}

	public logout() {
		this.authService.logout();
		this.toastrService.success("Successfully logged out!", "Warning", {
			timeOut: 3000,
			positionClass: 'toast-bottom-right'
		})
	}

	get authenticated(): boolean {
		return this.authService.authenticated;
	}

	get userId(): number{
		return this.authService.getUserInfo()?.id!;
	}
}
