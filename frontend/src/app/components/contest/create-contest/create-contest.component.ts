import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {City} from 'src/app/models/city';
import {MockdataService} from 'src/app/services/mock/mockdata.service';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Point} from "../../../models/point";
import {Contest} from "../../../models/contest";
import {Content} from "../../../models/content";

@Component({
	selector: 'app-create-contest',
	templateUrl: './create-contest.component.html',
	styleUrls: ['./create-contest.component.scss']
})
export class CreateContestComponent {

	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, public api: ApiService, private fb: FormBuilder) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.city = MockdataService.getCityMock(id);
			//this.getCityDetail();
		});
		this.form = this.fb.group({
			title: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required, Validators.maxLength(180)]),
			endDate: new FormControl('', [Validators.required])
		});
	}

	getCityDetail(): void {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.api.city.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}

	createContest(): void {
		if(this.form.valid) {
			const contest: Contest = this.getContestFromForm();
			// TODO: Send content to APIs
		}
	}

	private getContestFromForm(): Contest {
		if (!this.form.valid) throw new Error('Form data is not valid');
		return {
			title: this.form.get('name')?.value,
			description: this.form.get('description')?.value,
			publicationDate: new Date(),
			closingDate: this.form.get('closingDate')?.value,
			authorId: this.api.auth.getUserInfo()?.id!,
			cityId: this.city?.id!
		};
	}


}
