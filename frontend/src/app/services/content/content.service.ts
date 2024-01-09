import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Content} from "../../models/content";
import {City} from "../../models/city";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ContentService {

	constructor(private httpClient: HttpClient) { }

	public uploadContent(content: Content): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/content/upload`, content);
	}

	public getContentDetails(id: number): Observable<Content> {
		return this.httpClient.get<Content>(`${environment.apiUrl}/content/${id}`);
	}

	public deleteContent(id: number): Observable<any> {
		return this.httpClient.delete(`${environment.apiUrl}/content/${id}`);
	}

	public addFavorite(id: number): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/content/${id}/favorite`, {});
	}

}
