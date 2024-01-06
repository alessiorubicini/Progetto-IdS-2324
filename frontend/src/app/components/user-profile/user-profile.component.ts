import { Component } from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";
import {UserInfo} from "../../models/user-info";
import {ActivatedRoute} from "@angular/router";
import {MockdataService} from "../../services/mock/mockdata.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent {
	user?: UserInfo
	userId? : number;
	activeTab: string = 'contents';

	constructor(private route: ActivatedRoute, private authService: AuthService) {
		this.route.params.subscribe(params => {
			const userId = params["id"];
			this.userId = userId;
			if(userId == authService.getUserInfo()?.id) {
				this.user = this.authService.getUserInfo()!;
			} else {
				//this.user = this.userService.getUserInfo(userId);
			}
			this.user = MockdataService.getUserMock(userId);
		});
	}

	get authenticated(): boolean {
		return this.authService.authenticated;
	}

	get isUserProfile() : boolean {
		return this.userId == this.authService.getUserInfo()?.id;
	}

	setActiveTab(tab: string): void {
		this.activeTab = tab;
	}
}
