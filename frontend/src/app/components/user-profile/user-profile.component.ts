import { Component } from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";
import {UserInfo} from "../../models/user-info";
import {ActivatedRoute} from "@angular/router";
import {MockdataService} from "../../services/mock/mockdata.service";
import {UiService} from "../../services/facades/ui/ui.service";
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

	constructor(private ui: UiService, private api: ApiService) {
		this.ui.route.params.subscribe(params => {
			const userId = params["id"];
			this.userId = userId;
			if(userId == api.auth.getUserInfo()?.id) {
				this.user = api.auth.getUserInfo()!;
			} else {
				//this.user = this.api.user.getUserInfo(userId);
			}
			this.user = MockdataService.getUserMock(userId);
		});
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
