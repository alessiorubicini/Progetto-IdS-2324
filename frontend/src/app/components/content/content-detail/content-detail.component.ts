import { Component } from '@angular/core';
import {Content} from "../../../models/content";
import {ActivatedRoute} from "@angular/router";
import {MockdataService} from "../../../services/mock/mockdata.service";
import {City} from "../../../models/city";
import {Point} from "../../../models/point";
import {UserInfo} from "../../../models/user-info";
import {ApiService} from "../../../services/facades/api/api.service";

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

	constructor(private route: ActivatedRoute, private api: ApiService) {
		this.route.params.subscribe(params => {
			const contentId = params["contentId"];
			const pointId = params["pointId"];
			const cityId = params["id"];
			this.content = MockdataService.getContentMock(contentId);
			this.city = MockdataService.getCityMock(cityId);
			this.point = MockdataService.getPointMock(pointId);
			this.user = MockdataService.getUserMock(this.content.authorId);
			//this.getCityDetail(cityId);
			//this.getContentDetail(contentId);
			//this.getPointDetail(pointId)
		})
	}

	getContentDetail(id: number) : void {
		this.api.content.getContentDetails(id).subscribe((content) => {
			this.content = content;
		})
	}

	getCityDetail(id: number) {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getPointDetail(id: number) {
		this.api.point.getPointDetails(id).subscribe((point) => {
			this.point = point;
		})
	}
}
