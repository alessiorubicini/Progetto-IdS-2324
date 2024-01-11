import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import {ApiService} from "../../../services/facades/api/api.service";
import {Content} from "../../../models/content";
import {UserInfo} from "../../../models/user-info";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-contests-detail',
  templateUrl: './contests-detail.component.html',
  styleUrls: ['./contests-detail.component.scss']
})
export class ContestsDetailComponent {
    city?: City
	contest?: Contest
	author?: UserInfo
	proposedContents?: Content[]
	searching : Boolean = false;
	searchQuery: string = '';

	constructor(private route: ActivatedRoute, public api: ApiService, private router: Router, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const contestId = params["contestId"]
			this.getCityDetail(cityId);
			this.getContestDetail(contestId);
			this.getProposedContents(contestId);
		})
	}

	getCityDetail(id: number) {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getContestDetail(id: number){
		this.api.contest.getContestDetails(id).subscribe((contest) => {
			this.contest = contest;
			if(this.contest) {
				this.getUserDetail(this.contest!.authorId);
			}
		})
	}

	getUserDetail(id: number) {
		this.api.user.getUserDetails(id).subscribe((user) => {
			this.author = user;
		})
	}

	getProposedContents(id: number) {
		this.api.contest.getProposedContents(id).subscribe((contents) => {
			this.proposedContents = contents;
		})
	}

	get contents() : Content[] | undefined {
		if(this.searching) {
			return this.proposedContents!.filter(c => c.title.toLowerCase().startsWith(this.searchQuery.toLowerCase()));
		} else {
			return this.proposedContents;
		}
	}

	deleteContest() {
		this.api.contest.deleteContest(this.contest!.id!).subscribe({
			next: (data) => {
				this.toastr.success('', 'Contest deleted successfully');
				this.router.navigate(['city', this.city?.id]);
			},
			error: (error) => {
				console.error('Error:', error);
				console.log('Status:', error.status);
				this.toastr.error(error, 'Error while deleting contest');
			}
		});
	}

}
