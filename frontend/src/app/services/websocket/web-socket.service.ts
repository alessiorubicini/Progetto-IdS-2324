import {Injectable} from '@angular/core';
import {StompService} from '@stomp/ng2-stompjs';
import {Observable, Subject} from 'rxjs';
import {ToastrService} from 'ngx-toastr';
import { RxStomp } from '@stomp/rx-stomp';

@Injectable({
	providedIn: 'root'
})
export class WebSocketService extends RxStomp {
	constructor() {
		super();
	}
	
}
