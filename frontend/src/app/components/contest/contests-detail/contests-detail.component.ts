import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import {ApiService} from "../../../services/facades/api/api.service";
import {Content} from "../../../models/content";
import {UserInfo} from "../../../models/user-info";
import {ToastrService} from "ngx-toastr";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-contests-detail',
  templateUrl: './contests-detail.component.html',
  styleUrls: ['./contests-detail.component.scss']
})
export class ContestsDetailComponent {
	cityId?: number;
	contest?: Contest
	author?: UserInfo
	searching : Boolean = false;
	searchQuery: string = '';
	loading: Boolean = true;

	constructor(private route: ActivatedRoute, public api: ApiService, private router: Router, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const contestId = params["contestId"]
			this.cityId = cityId;
			this.getContestDetail(cityId, contestId);
		})
	}

	getContestDetail(cityId: number, contestId: number){
		this.api.contest.getContestDetails(cityId, contestId).subscribe((contest) => {
			this.contest = contest;
			if(this.contest) {
				this.getUserDetail(this.contest!.authorId);
			}
			this.loading = false;
		})
	}

	getUserDetail(id: number) {
		this.api.user.getUserDetails(id).subscribe((user) => {
			this.author = user;
		})
	}

	get contents() : Content[] | undefined {
		if(this.searching) {
			return this.contest?.contents!.filter(c => c.title.toLowerCase().startsWith(this.searchQuery.toLowerCase()));
		} else {
			return this.contest?.contents;
		}
	}

	deleteContest() {
		this.api.contest.deleteContest(this.cityId!, this.contest?.id!).subscribe({
			next: (data) => {
				this.toastr.success('', 'Contest deleted successfully');
				this.router.navigate(['city', this.contest?.id!]);
			},
			error: (error: HttpErrorResponse) => {
				console.error('Error:', error.error);
				this.toastr.error(error.error, 'Error while deleting contest');
			}
		});
	}

}
