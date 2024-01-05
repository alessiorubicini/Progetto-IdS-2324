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

	public getContentsOfPoint(id: number): Observable<Content[]> {
		return this.httpClient.get<Content[]>(`${environment.apiUrl}/point/${id}/contents`);
	}

	public getContentDetails(id: number): Observable<Content> {
		return this.httpClient.get<Content>(`${environment.apiUrl}/content/${id}`);
	}

}
