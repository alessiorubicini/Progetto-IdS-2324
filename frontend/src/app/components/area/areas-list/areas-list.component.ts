import {Component, Input} from '@angular/core';
import {City} from "../../../models/city";
import {MockdataService} from "../../../services/mock/mockdata.service";
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

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.city = MockdataService.getCityMock(id);
			this.areas = MockdataService.getAllPointMocksOfCity(id)?.filter(p => !p.longitude)!;
			//this.getCityDetail();
		})
	}

	getCityDetail() : void {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.api.city.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}
}
