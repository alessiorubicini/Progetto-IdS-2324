import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {City} from 'src/app/models/city';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Contest} from "../../../models/contest";
import {ToastrService} from "ngx-toastr";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
	selector: 'app-create-contest',
	templateUrl: './create-contest.component.html',
	styleUrls: ['./create-contest.component.scss']
})
export class CreateContestComponent {
	city?: City;
	form: FormGroup;
	loading: Boolean = true;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.getCityDetail(id);
		});
		this.form = this.fb.group({
			title: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required, Validators.maxLength(180)]),
			closingDate: new FormControl('', [Validators.required])
		});
	}

	getCityDetail(id: number): void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
			this.loading = false;
		})
	}

	createContest(): void {
		if(this.form.valid) {
			const contest: Contest = this.getContestFromForm();
			this.api.contest.addContest(contest).subscribe({
				next: (data) => {
					this.toastr.success('', 'Contest created successfully');
					this.router.navigate(['city', this.city?.id]);
				},
				error: (error: HttpErrorResponse) => {
					this.toastr.error(error.error, 'Error while creating contest');
				}
			});
		}
	}

	private getContestFromForm(): Contest {
		if (!this.form.valid) throw new Error('Form data is not valid');
		return {
			title: this.form.get('title')?.value,
			description: this.form.get('description')?.value,
			publicationDate: new Date(),
			closingDate: this.form.get('closingDate')?.value,
			authorId: this.api.auth.getUserInfo()?.id!,
			cityId: this.city?.id!
		};
	}


}
