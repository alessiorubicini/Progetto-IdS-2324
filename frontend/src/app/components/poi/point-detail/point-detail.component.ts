import { Component } from '@angular/core';
import {Point} from "../../../models/point";
import {Content} from "../../../models/content";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {City} from "../../../models/city";
import {UiService} from "../../../services/facades/ui/ui.service";
import {ApiService} from "../../../services/facades/api/api.service";

@Component({
  selector: 'app-point-detail',
  templateUrl: './point-detail.component.html',
  styleUrls: ['./point-detail.component.scss']
})
export class PointDetailComponent {
	city?: City
	point?: Point;
	contents?: Content[];

	constructor(private ui: UiService, private api: ApiService) {
		this.ui.route.params.subscribe(params => {
			const cityId = params["id"];
			const pointId = params["pointId"];
			this.city = MockdataService.getCityMock(cityId);
			this.point = MockdataService.getPointMock(pointId);
			this.contents = MockdataService.getContentsMocksOfPoint(pointId);
			//this.getCityDetail(cityId);
			//this.getPointDetail(cityId);
			//this.getPointContents(pointId);
		})
	}

	getCityDetail(id: number) {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getPointDetail(id: number) {
		this.api.point.getPointDetails(id).subscribe((point) => {
			this.point = point;
		})
	}

	getPointContents(id: number) {
		this.api.content.getContentsOfPoint(id).subscribe((contents) => {
			this.contents = contents;
		})
	}

	get authenticated(): boolean {
		return this.api.auth.authenticated;
	}
}
