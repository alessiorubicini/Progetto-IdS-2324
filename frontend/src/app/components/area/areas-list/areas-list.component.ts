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
	areas?: Point[]

	constructor(private route: ActivatedRoute, private cityService: CityService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.city = MockdataService.getCityMock(id);
			this.areas = MockdataService.getAllPointMocksOfCity(id)?.filter(p => p.longitude == undefined)!;
			//this.getCityDetail();
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

}
