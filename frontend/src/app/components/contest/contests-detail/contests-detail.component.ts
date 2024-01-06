import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from 'src/app/models/city';
import { Content } from 'src/app/models/content';
import { Contest } from 'src/app/models/contest';
import { Point } from 'src/app/models/point';
import { CityService } from 'src/app/services/city/city.service';
import { ContentService } from 'src/app/services/content/content.service';
import { MockdataService } from 'src/app/services/mock/mockdata.service';
import { PointService } from 'src/app/services/point/point.service';
import { ContestService} from 'src/app/services/contest/contest.service';

@Component({
  selector: 'app-contests-detail',
  templateUrl: './contests-detail.component.html',
  styleUrls: ['./contests-detail.component.scss']
})
export class ContestsDetailComponent {
    city?: City
	point?: Point
	content?: Content
	contest?: Contest

	constructor(private route: ActivatedRoute, private contentService: ContentService, private cityService: CityService, private pointService: PointService, private contestService: ContestService) {
		this.route.params.subscribe(params => {
			const contentId = params["contentId"];
			const pointId = params["pointId"];
			const cityId = params["id"];
			const contestId = params["contestId"]
			this.content = MockdataService.getContentMock();
			this.city = MockdataService.getCityMock(cityId);
			this.point = MockdataService.getPointMock(pointId);
			this.contest = MockdataService.getContestMock(contestId);
			//this.getCityDetail(cityId);
			//this.getContentDetail(contentId);
		})
	}

	getContentDetail(id: number) : void {
		this.contentService.getContentDetails(id).subscribe((content) => {
			this.content = content;
		})
	}

	getCityDetail(id: number) {
		this.cityService.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getPointDetail(id: number) {
		this.pointService.getPointDetails(id).subscribe((point) => {
			this.point = point;
		})
	}

	getContestDetail(id: number){
		this.contestService.getContestDetails(id).subscribe((contest) => {
			this.contest = contest;
		})	
	}
}
