import { Component } from '@angular/core';
import {Content} from "../../../models/content";
import {ActivatedRoute} from "@angular/router";
import {ContentService} from "../../../services/content/content.service";
import {MockdataService} from "../../../services/mock/mockdata.service";

@Component({
  selector: 'app-content-detail',
  templateUrl: './content-detail.component.html',
  styleUrls: ['./content-detail.component.scss']
})
export class ContentDetailComponent {
	content?: Content

	constructor(private route: ActivatedRoute, private contentService: ContentService) {
		this.route.params.subscribe(params => {
			const contentd = params["contentId"];
			this.content = MockdataService.getContentMock();
			//this.getCityDetail(cityId);
		})
	}

	getContentDetail(id: number) : void {
		this.contentService.getContentDetails(id).subscribe((content) => {
			this.content = content;
		})
	}

}
