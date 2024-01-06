import { Component } from '@angular/core';
import { City } from '../../../models/city';
import { MockdataService } from '../../../services/mock/mockdata.service';
import {Point} from "../../../models/point";
import {ApiService} from "../../../services/facades/api/api.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-points-of-interest',
  templateUrl: './points-of-interest.component.html',
  styleUrls: ['./points-of-interest.component.scss']
})
export class PointsOfInterestComponent {
	city?: City
	points?: Point[]

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.city = MockdataService.getCityMock(cityId);
			this.points = MockdataService.getAllPointMocksOfCity(cityId)!;
			//this.getCityDetail();
			//this.getCityPoints()
		})
	}

	getCityDetail(id: number) : void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getCityPoints(id: number) : void {
		this.api.point.getPointsOfCity(id).subscribe((points) => {
			this.points = points;
		})
	}

	get authenticated(): boolean {
		return this.api.auth.authenticated;
	}

	get physicalPoints() : Point[] {
		return this.points?.filter(p => p.latitude != undefined || p.longitude != undefined)!
	}
}


