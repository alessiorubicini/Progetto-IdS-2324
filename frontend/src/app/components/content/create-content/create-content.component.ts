import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {City} from '../../../models/city';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../../../services/facades/api/api.service";
import {Content} from "../../../models/content";
import {ContentStatus} from "../../../models/contentstatus";
import {Contest} from "../../../models/contest";
import {Point} from "../../../models/point";
import {ToastrService} from "ngx-toastr";
import {catchError, tap} from "rxjs";

@Component({
	selector: 'app-create-content',
	templateUrl: './create-content.component.html',
	styleUrls: ['./create-content.component.scss']
})
export class CreateContentComponent {
	city?: City;
	pointId?: number;
	form: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			const pointId = params["pointId"];
			this.pointId = pointId;
			this.getCityDetail(id);
		})
		this.form = fb.group({
			title: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required]),
			mediaUrl: new FormControl('', [Validators.required]),
			contestId: new FormControl('')
		});
	}

	createContent(): void {
		if (this.form.valid) {
			const content: Content = this.getContentFromForm();
			this.api.content.addContent(content, this.city?.id!).subscribe({
				next: (data) => {
					this.toastr.success('', 'Content created successfully');
					this.router.navigate(['city', this.city?.id, 'points', this.pointId!]);
				},
				error: (error) => {
					console.error('Error:', error);
					console.log('Status:', error.status);
					this.toastr.error(error, 'Error while creating content');
				}
			});
		}
	}

	getContentFromForm(): Content {
		if (this.form.valid && this.city && this.pointId) {
			return {
				title: this.form.get('title')?.value,
				description: this.form.get('description')?.value,
				publicationDate: new Date(),
				status: ContentStatus.DRAFT,
				authorId: this.api.auth.getUserInfo()?.id!,
				pointId: this.pointId!,
				mediaUrl: this.form.get('mediaUrl')?.value,
				contestId: this.form.get('contestId')?.value
			};
		} else {
			throw new Error('Form data is not valid');
		}
	}

	private getCityDetail(id: number): void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

}
