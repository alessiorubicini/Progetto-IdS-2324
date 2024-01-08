import {Component} from '@angular/core';
import {City} from "../../../models/city";
import {Point} from "../../../models/point";
import {ApiService} from "../../../services/facades/api/api.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-areas-list',
  templateUrl: './areas-list.component.html',
  styleUrls: ['./areas-list.component.scss']
})
export class AreasListComponent {
	city?: City
	areas?: Point[]

	constructor(private route: ActivatedRoute, public api: ApiService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.getCityDetail(id);
			this.getCityPoints(id)
		})
	}

	getCityDetail(id: number) : void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getCityPoints(id: number) : void {
		this.api.point.getPointsOfCity(id).subscribe((points) => {
			this.areas = points.filter(a => !a.latitude && !a.longitude);
		})
	}
}
