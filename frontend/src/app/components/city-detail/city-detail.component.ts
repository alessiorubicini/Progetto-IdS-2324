import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from '../../models/city';
import { CityService } from '../../services/city/city.service';
import { MockdataService } from '../../services/mock/mockdata.service';
import {ApiService} from "../../services/facades/api/api.service";

@Component({
	selector: 'app-city-detail',
	templateUrl: './city-detail.component.html',
	styleUrls: ['./city-detail.component.scss']
})
export class CityDetailComponent {
	city?: City;
	activeTab: string = 'pointsOfInterest';

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.city = MockdataService.getCityMock(cityId);
			//this.getCityDetail(cityId);
		})
	}

	getCityDetail(id: number) : void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	setActiveTab(tab: string): void {
		this.activeTab = tab;
	}
}
