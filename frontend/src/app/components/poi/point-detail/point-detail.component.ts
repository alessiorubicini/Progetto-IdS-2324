import { Component } from '@angular/core';
import {Point} from "../../../models/point";
import {Content} from "../../../models/content";
import {ActivatedRoute} from "@angular/router";
import {ContentService} from "../../../services/content/content.service";
import {PointService} from "../../../services/point/point.service";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {City} from "../../../models/city";
import {CityService} from "../../../services/city/city.service";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-point-detail',
  templateUrl: './point-detail.component.html',
  styleUrls: ['./point-detail.component.scss']
})
export class PointDetailComponent {
	city?: City
	point?: Point;
	contents?: Content[];

	constructor(private route: ActivatedRoute, private authService: AuthService, private cityService: CityService, private contentService: ContentService, private pointService: PointService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const pointId = params["pointId"];
			this.city = MockdataService.getCityMock(cityId);
			this.point = MockdataService.getPointMock(pointId);
			this.contents = [MockdataService.getContentMock()];
			//this.getCityDetail(cityId);
			//this.getPointDetail(cityId);
			//this.getPointContents(pointId);
		})
	}

	getCityDetail(id: number) {
		this.cityService.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getPointDetail(id: number) {
		this.pointService.getPointDetails(id).subscribe((point) => {
			this.point = point;
		})
	}

	getPointContents(id: number) {
		this.contentService.getContentsOfPoint(id).subscribe((contents) => {
			this.contents = contents;
		})
	}

	get authenticated(): boolean {
		return this.authService.authenticated;
	}
}
