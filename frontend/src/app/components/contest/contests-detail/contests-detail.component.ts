import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { City } from 'src/app/models/city';
import { Contest } from 'src/app/models/contest';
import { CityService } from 'src/app/services/city/city.service';
import { MockdataService } from 'src/app/services/mock/mockdata.service';
import { ContestService} from 'src/app/services/contest/contest.service';
import { AuthService } from 'src/app/services/auth/auth.service';
import {ApiService} from "../../../services/facades/api/api.service";
import {Content} from "../../../models/content";
import {UserInfo} from "../../../models/user-info";

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

	constructor(private route: ActivatedRoute, private api: ApiService) {
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

}
