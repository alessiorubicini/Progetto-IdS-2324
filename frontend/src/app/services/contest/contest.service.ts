import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Contest} from 'src/app/models/contest';
import {environment} from 'src/environments/environment';

@Injectable({
	providedIn: 'root'
})
export class ContestService {

	constructor(private httpClient: HttpClient) { }

	public getContestsOfCity(cityId: number): Observable<Contest[]> {
		return this.httpClient.get<Contest[]>(`${environment.apiUrl}/city/${cityId}/contests`);
	}

	public getContestDetails(cityId: number, contestId: number): Observable<Contest> {
		return this.httpClient.get<Contest>(`${environment.apiUrl}/city/${cityId}/contests/${contestId}`);
	}

	public addContest(contest: Contest): Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/city/${contest.cityId}/contests`, contest);
	}

	public deleteContest(cityId: number, contestId: number): Observable<any> {
		return this.httpClient.delete(`${environment.apiUrl}/city/${cityId}/contests/${contestId}`);
	}

	public proclaimWinner(cityId: number, contestId: number, userId: number): Observable<any> {
		return this.httpClient.put(`${environment.apiUrl}/city/${cityId}/contests/${contestId}/proclaimWinner?userId=${userId}`, {})
	}

}
