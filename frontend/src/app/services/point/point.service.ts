import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Point } from 'src/app/models/point';
import {Content} from "../../models/content";

@Injectable({
  providedIn: 'root'
})
export class PointService {

	constructor(private httpClient: HttpClient) { }

	public getPointsOfCity(cityId: number) : Observable<Point[]> {
		return this.httpClient.get<Point[]>(`${environment.apiUrl}/city/${cityId}/points`);
	}

	public getPointDetails(cityId: number, pointId: number) : Observable<Point> {
		return this.httpClient.get<Point>(`${environment.apiUrl}/city/${cityId}/points/${pointId}`);
	}

	public addPoint(point: Point) : Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/city/${point.cityId}/points`, point);
	}

	public deletePoint(cityId: number, pointId: number): Observable<any> {
		return this.httpClient.delete(`${environment.apiUrl}/city/${cityId}/points/${pointId}`);
	}

}
