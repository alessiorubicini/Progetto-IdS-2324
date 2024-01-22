import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Content} from "../../models/content";
import {environment} from "../../../environments/environment";

@Injectable({
	providedIn: 'root'
})
export class ContentService {

	constructor(private httpClient: HttpClient) {
	}

	public getContentsOfPoint(cityId: number, pointId: number): Observable<Content[]> {
		return this.httpClient.get<Content[]>(`${environment.apiUrl}/city/${cityId}/points/${pointId}/contents`);
	}

	public getContentDetails(cityId: number, pointId: number, contentId: number): Observable<Content> {
		return this.httpClient.get<Content>(`${environment.apiUrl}/city/${cityId}/points/${pointId}/contents/${contentId}`);
	}

	public addContent(content: Content, cityId: number): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/city/${cityId}/points/${content.pointId}/contents/`, content);
	}

	public deleteContent(cityId: number, pointId: number, contentId: number): Observable<any> {
		return this.httpClient.delete(`${environment.apiUrl}/city/${cityId}/points/${pointId}/contents/${contentId}`);
	}

	public addFavorite(cityId: number, pointId: number, contentId: number): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/city/${cityId}/points/${pointId}/contents/${contentId}/favorite`, {});
	}

}
