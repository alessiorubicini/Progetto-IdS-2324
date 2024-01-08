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
	cities?: City[];
	searching : Boolean = false;
	searchQuery: string = '';

	constructor(private api: ApiService) {
		this.api.city.getAllCities().subscribe((cities) => {
			this.cities = cities;
		})
	}

	get allCities() : City[] | undefined {
		if(this.searching) {
			return this.cities!.filter(c => c.name.toLowerCase().startsWith(this.searchQuery.toLowerCase()));
		} else {
			return this.cities;
		}
	}

}
