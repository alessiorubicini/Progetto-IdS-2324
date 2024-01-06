import { Injectable } from '@angular/core';
import {AuthService} from "../../auth/auth.service";
import {CityService} from "../../city/city.service";
import {PointService} from "../../point/point.service";
import {ContentService} from "../../content/content.service";

@Injectable({
  providedIn: 'root'
})
// This is a facade single interface to the variety of API services
export class ApiService {

  constructor(public auth: AuthService, public city: CityService,
			  public point: PointService, public content: ContentService) { }
}
