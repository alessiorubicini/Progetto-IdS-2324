import { Injectable } from '@angular/core';
import {
	HttpRequest,
	HttpHandler,
	HttpEvent,
	HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HeaderInterceptor implements HttpInterceptor {

	intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
		const modifiedRequest = request.clone({
			setHeaders: {
				'Content-Type': 'application/json',
				'Authorization': 'Bearer ' + localStorage.getItem("access_token")!
			}
		});
		return next.handle(modifiedRequest);
	}
}
