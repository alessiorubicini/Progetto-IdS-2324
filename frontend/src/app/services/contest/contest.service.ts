import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Point } from 'leaflet';
import { Observable } from 'rxjs';
import { Contest } from 'src/app/models/contest';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContestService {

  constructor(private httpClient: HttpClient) { }

  public getContestOfCity(id: number) : Observable<Contest[]> {
		return this.httpClient.get<Contest[]>(`${environment.apiUrl}/city/${id}/contests`);
	}

  public getContestDetails(id: number) : Observable<Contest> {
    return this.httpClient.get<Contest>(`${environment.apiUrl}/city/${id}/contests`);
  }

}
