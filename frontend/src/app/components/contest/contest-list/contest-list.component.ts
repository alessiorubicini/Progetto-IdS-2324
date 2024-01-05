import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Point } from 'leaflet';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import { AuthService } from 'src/app/services/auth/auth.service';
import { CityService } from 'src/app/services/city/city.service';
import { MockdataService } from 'src/app/services/mock/mockdata.service';
import { PointService } from 'src/app/services/point/point.service';

@Component({
  selector: 'app-contest-list',
  templateUrl: './contest-list.component.html',
  styleUrls: ['./contest-list.component.scss']
})
export class ContestListComponent {
  
	@Input() cityId?: number;
	city?: City
	points?: Point[]

	constructor(private route: ActivatedRoute, private authService: AuthService, private cityService: CityService, private pointService: PointService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.city = MockdataService.getCityMock(cityId);
			//this.points = MockdataService.getAllPointMocksOfCity(cityId)!;
			//this.getCityDetail();
			//this.getCityPoints()
		})
	}

	getCityDetail(id: number) : void {
		this.cityService.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	
}
