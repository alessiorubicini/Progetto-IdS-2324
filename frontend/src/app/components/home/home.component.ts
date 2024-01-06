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

	public onSearch(event: any) {
		this.searchQuery = event.target.value;
        this.searching = this.searchQuery.length > 0;
        this.citiesFiltered = this.cities.filter(city =>
            city.name.toLowerCase().startsWith(this.searchQuery.toLowerCase())
        );
	}

}
