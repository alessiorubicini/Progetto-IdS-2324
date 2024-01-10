import {Component} from '@angular/core';
import {ApiService} from "./services/facades/api/api.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import { Meta } from '@angular/platform-browser';
import {WebSocketService} from "./services/websocket/web-socket.service";
import {catchError, forkJoin, Subject, Subscription, takeUntil} from "rxjs";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'OpenCity';
	//private ngUnsubscribe = new Subject();
	connections: Subscription[] = [];

	//, private webSocketService: WebSocketService
	constructor(private api: ApiService, public toastr: ToastrService, public titleService: Title, private meta: Meta) {
		this.titleService.setTitle("OpenCity");
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: light)' });
		this.meta.addTag({ name: 'theme-color', content: '#D9EAFB', media: '(prefers-color-scheme: dark)' });

		/*
		for (let participation of api.roles.getAllUserRoles()) {
			console.log("Role: "+ participation.role.title)
			if(participation.role.title === 'Curator' || participation.role.title == 'City Manager') {
				this.connections.push(
					this.webSocketService
						.connect(participation.city.id!)
						.pipe(takeUntil(this.ngUnsubscribe),
							catchError((error) => {
								console.error('WebSocket connection error:', error);
								throw error;
							}))
						.subscribe((message: any) => {
							this.webSocketService.handleReceivedMessage(message.body);
						})
				);
			}
		}*/

		forkJoin(this.connections).subscribe(() => {
			console.log('All web sockets connected.');
		});

		/*this.webSocketService.getMessageSubject()
			.pipe(takeUntil(this.ngUnsubscribe))
			.subscribe((message: string) => {
				// Handle the message in your component if needed
				console.log('Received message in component:', message);
			});

		 */
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
