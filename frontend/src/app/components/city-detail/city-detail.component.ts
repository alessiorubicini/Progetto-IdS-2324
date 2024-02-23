import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from '../../models/city';
import {ApiService} from "../../services/facades/api/api.service";

@Component({
	selector: 'app-city-detail',
	templateUrl: './city-detail.component.html',
	styleUrls: ['./city-detail.component.scss']
})
export class CityDetailComponent {
	city?: City;
	loading: Boolean = true;
	activeTab: string = 'pointsOfInterest';

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.getCityDetail(cityId);
		});
	}

	getCityDetail(id: number) : void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
			this.loading = false;
		})
	}

	setActiveTab(tab: string): void {
		this.activeTab = tab;
	}
}
