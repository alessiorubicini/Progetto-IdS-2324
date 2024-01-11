import {Component, OnDestroy, OnInit} from '@angular/core';
import {ApiService} from "./services/facades/api/api.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import { Meta } from '@angular/platform-browser';
import {WebSocketService} from "./services/websocket/web-socket.service";
import {catchError, forkJoin, Subject, Subscription, takeUntil} from "rxjs";
import { Message } from '@stomp/stompjs';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
	title = 'OpenCity';
	connections: Subscription[] = [];

	constructor(private api: ApiService, public toastr: ToastrService, public titleService: Title, private meta: Meta, private webSocketService: WebSocketService) {
		this.titleService.setTitle("OpenCity");
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: light)' });
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: dark)' });

	}

	ngOnInit() {
		for (let participation of this.api.roles.getAllUserRoles()) {
			console.log("Role: "+ participation.role.title)
			if(participation.role.title === 'Curator' || participation.role.title == 'City Manager') {
				this.connections.push(this.webSocketService
					.watch(`/messages/city/${participation.city.id}`)
					.subscribe((message: Message) => {
						this.toastr.show(message.body, 'Message from server');
					}));
			}
		}
	}

	ngOnDestroy() {
		for(let conn of this.connections) {
			conn.unsubscribe();
		}
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
