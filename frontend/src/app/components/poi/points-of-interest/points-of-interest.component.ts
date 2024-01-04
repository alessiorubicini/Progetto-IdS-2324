import { Component, Input } from '@angular/core';
import { City } from '../../../models/city';
import { ActivatedRoute } from '@angular/router';
import { CityService } from '../../../services/city/city.service';
import { MockdataService } from '../../../services/mock/mockdata.service';
import {PointService} from "../../../services/point/point.service";
import {Point} from "../../../models/point";

@Component({
  selector: 'app-points-of-interest',
  templateUrl: './points-of-interest.component.html',
  styleUrls: ['./points-of-interest.component.scss']
})
export class PointsOfInterestComponent {
	@Input() cityId?: number;
	city?: City
	points?: Point[]

	constructor(private route: ActivatedRoute, private cityService: CityService, private pointService: PointService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.city = MockdataService.getCityMock(cityId);
			this.points = [MockdataService.getPointMock()];
			//this.getCityDetail();
			//this.getCityPoints()
		})
	}

	getCityDetail(id: number) : void {
		this.cityService.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getCityPoints(id: number) : void {
		this.pointService.getPointsOfCity(id).subscribe((points) => {
			this.points = points;
		})
	}

}


