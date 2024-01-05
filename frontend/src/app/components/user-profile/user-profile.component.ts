import { Component } from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";
import {UserInfo} from "../../models/user-info";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent {

	constructor(private authService: AuthService) { }

	get authenticated(): boolean {
		return this.authService.authenticated;
	}

	get userInfo() : UserInfo |  null {
		return this.authService.getUserInfo();
	}
}
