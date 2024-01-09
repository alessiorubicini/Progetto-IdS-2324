import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Point} from 'leaflet';
import {Observable} from 'rxjs';
import {Contest} from 'src/app/models/contest';
import {environment} from 'src/environments/environment';
import {Content} from "../../models/content";

@Injectable({
	providedIn: 'root'
})
export class ContestService {

	constructor(private httpClient: HttpClient) { }

	public suggestContest(contest: Contest): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/contest/suggest`, contest);
	}

	public getContestOfCity(id: number): Observable<Contest[]> {
		return this.httpClient.get<Contest[]>(`${environment.apiUrl}/city/${id}/contests`);
	}

	public getContestDetails(id: number): Observable<Contest> {
		return this.httpClient.get<Contest>(`${environment.apiUrl}/contest/${id}`);
	}

	public getProposedContents(id: number): Observable<Content[]> {
		return this.httpClient.get<Content[]>(`${environment.apiUrl}/contest/${id}/contents`);
	}

	public deleteContest(id: number): Observable<any> {
		return this.httpClient.delete(`${environment.apiUrl}/contest/${id}`);
	}

}
