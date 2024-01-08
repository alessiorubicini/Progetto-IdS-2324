import { Component } from '@angular/core';
import {Point} from "../../../models/point";
import {Content} from "../../../models/content";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {City} from "../../../models/city";
import {ApiService} from "../../../services/facades/api/api.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-point-detail',
  templateUrl: './point-detail.component.html',
  styleUrls: ['./point-detail.component.scss']
})
export class PointDetailComponent {
	city?: City
	point?: Point;
	contents?: Content[];

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const pointId = params["pointId"];
			this.getCityDetail(cityId);
			this.getPointDetail(pointId);
			//this.getPointContents(pointId);
			// TODO: waiting for route in APIs
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
