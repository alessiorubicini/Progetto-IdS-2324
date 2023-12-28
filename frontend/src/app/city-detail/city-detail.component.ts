import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from '../models/city';
import { CityService } from '../services/city/city.service';
import { map, switchMap } from 'rxjs';

@Component({
	selector: 'app-city-detail',
	templateUrl: './city-detail.component.html',
	styleUrls: ['./city-detail.component.scss']
})
export class CityDetailComponent {
	city?: City;
	
	constructor(private route: ActivatedRoute, private cityService: CityService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.cityService.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}
}
