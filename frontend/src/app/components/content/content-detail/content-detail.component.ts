import { Component } from '@angular/core';
import {Content} from "../../../models/content";
import {ActivatedRoute} from "@angular/router";
import {ContentService} from "../../../services/content/content.service";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {City} from "../../../models/city";
import {CityService} from "../../../services/city/city.service";
import {Point} from "../../../models/point";
import {PointService} from "../../../services/point/point.service";
import {UserInfo} from "../../../models/user-info";

@Component({
  selector: 'app-content-detail',
  templateUrl: './content-detail.component.html',
  styleUrls: ['./content-detail.component.scss']
})
export class ContentDetailComponent {
	city?: City
	point?: Point
	content?: Content
	user?: UserInfo

	constructor(private route: ActivatedRoute, private contentService: ContentService, private cityService: CityService, private pointService: PointService) {
		this.route.params.subscribe(params => {
			const contentId = params["contentId"];
			const pointId = params["pointId"];
			const cityId = params["id"];
			this.content = MockdataService.getContentMock();
			this.city = MockdataService.getCityMock(cityId);
			this.point = MockdataService.getPointMock(pointId);
			this.user = MockdataService.getUserMock(this.content.authorId);
			//this.getCityDetail(cityId);
			//this.getContentDetail(contentId);
			//this.getPointDetail(pointId)
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

}
