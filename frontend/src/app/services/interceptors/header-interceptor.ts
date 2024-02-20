import { Injectable } from '@angular/core';
import {
	HttpRequest,
	HttpHandler,
	HttpEvent,
	HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../../../environments/environment";

@Injectable()
export class HeaderInterceptor implements HttpInterceptor {

	intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
		const excludedUrls = [`${environment.apiUrl}/auth/signup`, `${environment.apiUrl}/auth/login`];
		console.log(request.url)
		if(excludedUrls.some(url => request.url.includes(url))) {
			return next.handle(request);
		}

		const modifiedRequest = request.clone({
			setHeaders: {
				'Content-Type': 'application/json',
				'Authorization': 'Bearer ' + localStorage.getItem("access_token")!
			}
		});

		return next.handle(modifiedRequest);
	}
}
