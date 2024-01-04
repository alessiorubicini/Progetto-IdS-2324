import {Component, Input} from '@angular/core';
import {City} from "../../../models/city";
import {ActivatedRoute} from "@angular/router";
import {CityService} from "../../../services/city/city.service";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {Point} from "../../../models/point";

@Component({
  selector: 'app-areas-list',
  templateUrl: './areas-list.component.html',
  styleUrls: ['./areas-list.component.scss']
})
export class AreasListComponent {
	@Input() cityId?: number;
	city?: City

	constructor(private route: ActivatedRoute, private cityService: CityService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			//this.getCityDetail();
			this.city = MockdataService.getCityMock(id);
		})
	}

	getCityDetail() : void {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.cityService.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}

	cityAreas() : Point[] {
		//return this.city!.points.filter(p => p.latitude == undefined && p.longitude == undefined);
		return [];
	}
}
