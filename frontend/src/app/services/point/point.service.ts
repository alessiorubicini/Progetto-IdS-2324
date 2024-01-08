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

	public getPointsOfCity(id: number) : Observable<Point[]> {
		return this.httpClient.get<Point[]>(`${environment.apiUrl}/city/${id}/points`);
	}

	public getPointDetails(id: number) : Observable<Point> {
		return this.httpClient.get<Point>(`${environment.apiUrl}/point/${id}`);
	}

	public addPoint(point: Point) : Observable<any> {
		return this.httpClient.post(`${environment.apiUrl}/point/`, point);
	}

	public getContentsOfPoint(id: number): Observable<Content[]> {
		return this.httpClient.get<Content[]>(`${environment.apiUrl}/point/${id}/contents`);
	}
}
