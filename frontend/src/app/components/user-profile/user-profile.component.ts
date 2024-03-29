import { Component } from '@angular/core';
import {UserInfo} from "../../models/user-info";
import {ActivatedRoute} from "@angular/router";
import {ApiService} from "../../services/facades/api/api.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent {
	user?: UserInfo
	userId? : number;
	activeTab: string = 'contents';

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const userId = params["id"];
			this.userId = userId;
			if(userId == api.auth.getUserInfo()?.id) {
				this.user = api.auth.getUserInfo()!;
			} else {
				this.getUserDetails(userId);
			}
		});
	}

	private getUserDetails(id: number) {
		this.api.user.getUserDetails(id).subscribe((user) => {
			this.user = user;
		})
	}

	get authenticated(): boolean {
		return this.api.auth.authenticated;
	}

	get isUserProfile() : boolean {
		return this.userId == this.api.auth.getUserInfo()?.id;
	}

	setActiveTab(tab: string): void {
		this.activeTab = tab;
	}
}
