import {Component} from '@angular/core';
import {ApiService} from "./services/facades/api/api.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';

	constructor(private api: ApiService, public toastr: ToastrService, public titleService: Title) {
		this.titleService.setTitle("OpenCity");
	}

	public logout() {
		this.api.auth.logout();
		this.toastr.success("Successfully logged out!", "Warning", {
			timeOut: 3000,
			positionClass: 'toast-bottom-right'
		})
	}

	get authenticated(): boolean {
		return this.api.auth.authenticated;
	}

	get userId(): number{
		return this.api.auth.getUserInfo()?.id!;
	}
}
