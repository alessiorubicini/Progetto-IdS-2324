import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import {ApiService} from "../../../services/facades/api/api.service";

@Component({
  selector: 'app-contest-list',
  templateUrl: './contest-list.component.html',
  styleUrls: ['./contest-list.component.scss']
})
export class ContestListComponent {
	city?: City
	contests?: Contest[]

	constructor(private route: ActivatedRoute, public api: ApiService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.getCityDetail(cityId);
			this.getCityContests(cityId);
		})
	}

	getCityDetail(id: number) : void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getCityContests(id: number) : void {
		this.api.contest.getContestOfCity(id).subscribe((contests) => {
			this.contests = contests;
		})
	}

}
