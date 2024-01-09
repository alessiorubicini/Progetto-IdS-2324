import { Component } from '@angular/core';
import {Content} from "../../../models/content";
import {ActivatedRoute} from "@angular/router";
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

	constructor(private route: ActivatedRoute, public api: ApiService) {
		this.route.params.subscribe(params => {
			const contentId = params["contentId"];
			const pointId = params["pointId"];
			const cityId = params["id"];
			this.getCityDetail(cityId);
			this.getPointDetail(pointId);
			this.getContentDetail(contentId);
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

	getContentDetail(id: number) : void {
		this.api.content.getContentDetails(id).subscribe((content) => {
			this.content = content;
			if(this.content) {
				this.getUserDetail(this.content!.authorId);
			}
		})
	}

	getUserDetail(id: number) {
		this.api.user.getUserDetails(id).subscribe((user) => {
			this.user = user;
		})
	}

	deleteContent() {
		this.api.content.deleteContent(this.content!.id!);
	}

	addAsFavorite() {
		this.api.content.addFavorite(this.content!.id!);
	}
}
