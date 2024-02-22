import {Component} from '@angular/core';
import {Content} from "../../../models/content";
import {ActivatedRoute, Router} from "@angular/router";
import {City} from "../../../models/city";
import {Point} from "../../../models/point";
import {UserInfo} from "../../../models/user-info";
import {ApiService} from "../../../services/facades/api/api.service";
import {ToastrService} from "ngx-toastr";
import {catchError, tap} from "rxjs";

@Component({
	selector: 'app-content-detail',
	templateUrl: './content-detail.component.html',
	styleUrls: ['./content-detail.component.scss']
})
export class ContentDetailComponent {
	content?: Content
	cityId?: number
	user?: UserInfo

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const contentId = params["contentId"];
			const pointId = params["pointId"];
			const cityId = params["id"];
			this.cityId = cityId;
			this.getContentDetail(cityId, pointId, contentId);
		})
	}

	getContentDetail(cityId: number, pointId: number, contentId: number): void {
		this.api.content.getContentDetails(cityId, pointId, contentId).subscribe((content) => {
			this.content = content;
			if (this.content) {
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
		this.api.content.deleteContent(this.cityId!, this.content?.pointId!, this.content?.id!).subscribe({
			next: (data) => {
				this.toastr.success('', 'Content deleted successfully');
				this.router.navigate(['city', this.cityId!, 'points', this.content?.pointId!]);
			},
			error: (error) => {
				this.toastr.error(error, 'Error while creating content');
				throw error;
			}
		});
	}

}
