import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import { CityService } from 'src/app/services/city/city.service';
import { MockdataService } from 'src/app/services/mock/mockdata.service';
import { ContestService} from 'src/app/services/contest/contest.service';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-contests-detail',
  templateUrl: './contests-detail.component.html',
  styleUrls: ['./contests-detail.component.scss']
})
export class ContestsDetailComponent {
    city?: City
	contest?: Contest

	constructor(private route: ActivatedRoute, private authService: AuthService, private cityService: CityService, private contestService: ContestService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const contestId = params["contestId"]
			this.city = MockdataService.getCityMock(cityId);
			this.contest = MockdataService.getContestMock(contestId);
			//this.getCityDetail(cityId);
			//this.getContentDetail(contentId);		
		})
	}

	getCityDetail(id: number) {
		this.cityService.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getContestDetail(id: number){
		this.contestService.getContestDetails(id).subscribe((contest) => {
			this.contest = contest;
		})	
	}
}
