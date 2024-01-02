import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PointService } from '../services/point/point.service';
import { City } from '../models/city';
import { CityService } from '../services/city/city.service';
import { MockdataService } from '../services/mock/mockdata.service';

@Component({
  selector: 'app-create-content',
  templateUrl: './create-content.component.html',
  styleUrls: ['./create-content.component.scss']
})
export class CreateContentComponent {

	// TODO: aggiungere form con informazioni contenuto
	city?: City;
	activeTab: string = 'pointsOfInterest';
	
	constructor(private route: ActivatedRoute, private cityService: CityService, private pointService: PointService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			//this.getCityDetail();
			this.city = MockdataService.getCityMocks()[0];
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

	createContent() : void {
		// TODO: aggiungere chiamata POST alle API per inviare nuovo content
	}
	
}
