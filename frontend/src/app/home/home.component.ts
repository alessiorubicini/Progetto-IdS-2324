import { Component, OnInit } from '@angular/core';
import { City } from '../models/city';
import { CityService } from '../services/city/city.service';
import { tap } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

	cities: City[] = [];
	
	constructor(private cityService: CityService) { }

	ngOnInit(): void {
		// TODO: Aspettando che le API siano pronte
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
		console.log('Searching: ', event.target.value);
		// TODO: Aspettando che le API siano pronte
		//this.getAllCities()
	}

}
