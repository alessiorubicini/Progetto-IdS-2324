import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Point } from 'src/app/models/point';

@Injectable({
  providedIn: 'root'
})
export class PointService {

	constructor(private httpClient: HttpClient) { }

	public getPointsOfCity(id: number) : Observable<Point[]> {
		return this.httpClient.get<Point[]>(`${environment.apiUrl}/city/${id}/points`);
	}

	public getPointDetails(id: number) : Observable<Point> {
		return this.httpClient.get<Point>(`${environment.apiUrl}/city/${id}/points`);
	}
}
