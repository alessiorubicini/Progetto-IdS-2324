import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {City} from "../../models/city";
import {environment} from "../../../environments/environment";
import {UserInfo} from "../../models/user-info";
import {HttpClient} from "@angular/common/http";

@Injectable({
	providedIn: 'root'
})
export class UserService {

	constructor(private httpClient: HttpClient) { }

	public getUserDetails(id: number): Observable<UserInfo> {
		return this.httpClient.get<UserInfo>(`${environment.apiUrl}/users/${id}`);
	}
}
