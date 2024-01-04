import { Component, Input } from '@angular/core';
import { City } from '../../../models/city';
import { ActivatedRoute } from '@angular/router';
import { CityService } from '../../../services/city/city.service';
import { MockdataService } from '../../../services/mock/mockdata.service';

@Component({
  selector: 'app-points-of-interest',
  templateUrl: './points-of-interest.component.html',
  styleUrls: ['./points-of-interest.component.scss']
})
export class PointsOfInterestComponent {
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

}


