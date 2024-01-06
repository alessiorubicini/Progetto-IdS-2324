import {Component} from '@angular/core';
import {ApiService} from "./services/facades/api/api.service";
import {UiService} from "./services/facades/ui/ui.service";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';

	constructor(private api: ApiService, private ui: UiService) {
		this.ui.title.setTitle("OpenCity");
	}

	public logout() {
		this.api.auth.logout();
		this.ui.toastr.success("Successfully logged out!", "Warning", {
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
