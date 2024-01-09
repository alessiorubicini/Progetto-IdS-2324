import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {City} from 'src/app/models/city';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Contest} from "../../../models/contest";

@Component({
	selector: 'app-create-contest',
	templateUrl: './create-contest.component.html',
	styleUrls: ['./create-contest.component.scss']
})
export class CreateContestComponent {

	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.getCityDetail(id);
		});
		this.form = this.fb.group({
			title: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required, Validators.maxLength(180)]),
			endDate: new FormControl('', [Validators.required])
		});
	}

	getCityDetail(id: number): void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	createContest(): void {
		if(this.form.valid) {
			const contest: Contest = this.getContestFromForm();
			this.api.contest.suggestContest(contest).subscribe(
				(data) => {
					if (data.status === 200) {
						this.router.navigate(['../']);
					}
				},
				(error) => {
					console.error('Error:', error);
					console.log('Status:', error.status);
				})
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
