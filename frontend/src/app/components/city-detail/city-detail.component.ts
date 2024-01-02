import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from '../../models/city';
import { CityService } from '../../services/city/city.service';
import { MockdataService } from '../../services/mock/mockdata.service';
//import { PointsOfInterestComponent } from '../points-of-interest/points-of-interest.component';
//import { AreasComponent } from '../areas/areas.component';
//import { ContestsComponent } from '../contests/contests.component';

@Component({
	selector: 'app-city-detail',
	templateUrl: './city-detail.component.html',
	styleUrls: ['./city-detail.component.scss']
})
export class CityDetailComponent {
	city?: City;
	activeTab: string = 'pointsOfInterest';

	constructor(private route: ActivatedRoute, private cityService: CityService) {
		//this.getCityDetail();
		this.city = MockdataService.getCityMocks()[0];
	}

	getCityDetail() : void {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.cityService.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}

	setActiveTab(tab: string): void {
		this.activeTab = tab;
	}
}
