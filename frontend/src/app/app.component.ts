import {Component} from '@angular/core';
import {ApiService} from "./services/facades/api/api.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import { Meta } from '@angular/platform-browser';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';

	constructor(private api: ApiService, public toastr: ToastrService, public titleService: Title, private meta: Meta) {
		this.titleService.setTitle("OpenCity");
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: light)' });
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: dark)' });
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
		return this.api.auth.getUserInfo()!.id!;
	}

	get username() : string {
		return this.api.auth.getUserInfo()!.username;
	}
}
