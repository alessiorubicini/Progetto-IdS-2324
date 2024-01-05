import { Component, OnInit } from '@angular/core';
import { City } from '../../models/city';
import { CityService } from '../../services/city/city.service';
import { Router } from '@angular/router';
import { MockdataService } from '../../services/mock/mockdata.service';


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

	constructor(private cityService: CityService, private router: Router) {
		this.cities = MockdataService.getAllCityMocks();
		//this.getAllCities()
	}

	private getAllCities() : void {
		this.cityService.getAllCities()
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
