import { Injectable } from '@angular/core';
import { StompService } from '@stomp/ng2-stompjs';
import { Observable, Subject } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
	private messageSubject = new Subject<string>();

	constructor(private stompService: StompService, private toastr: ToastrService) {}

	connect(cityId: number): Observable<any> {
		return this.stompService.subscribe(`/messages/city/${cityId}`);
	}

	sendMessage(message: string, cityId: number): void {
		this.stompService.publish(`/messages/city/${cityId}`, message);
	}

	handleReceivedMessage(message: string): void {
		this.messageSubject.next(message);
		this.toastr.success(message, 'Received message from server');
	}

	getMessageSubject(): Observable<string> {
		return this.messageSubject.asObservable();
	}
}
