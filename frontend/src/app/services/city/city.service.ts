import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { City } from 'src/app/models/city';
import {Point} from "../../models/point";

@Injectable({
  providedIn: 'root'
})
export class CityService {

	constructor(private httpClient: HttpClient) { }

	public getAllCities() : Observable<City[]> {
		return this.httpClient.get<City[]>(`${environment.apiUrl}/city/`);
	}

	public getCityById(id: number) : Observable<City> {
		return this.httpClient.get<City>(`${environment.apiUrl}/city/${id}`);
	}

	public getPointsOfCity(id: number) : Observable<Point[]> {
		return this.httpClient.get<Point[]>(`${environment.apiUrl}/city/${id}/points`);
	}
}

