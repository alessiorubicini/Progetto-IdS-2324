import { Component } from '@angular/core';
import { City } from '../../models/city';
import { MockdataService } from '../../services/mock/mockdata.service';
import {ApiService} from "../../services/facades/api/api.service";

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.scss']
})
export class HomeComponent {

	cities: City[];
	searching : Boolean = false;
	searchQuery: string = '';
    citiesFiltered: City[] = [];

	constructor(private api: ApiService) {
		this.cities = MockdataService.getAllCityMocks();
		//this.getAllCities()
	}

	private getAllCities() : void {
		this.api.city.getAllCities()
			.subscribe({
				next: (result) => {
					console.log('Cities fetched successfully: ', result);
				},
				error: (error) => {
					console.error('Fetch failed:', error);
				},
				complete: () => { }
			});
	}

	get allCities() : City[] | undefined {
		if(this.searching) {
			return this.cities.filter(c => c.name.toLowerCase().startsWith(this.searchQuery.toLowerCase()));
		} else {
			return this.cities;
		}
	}

}
