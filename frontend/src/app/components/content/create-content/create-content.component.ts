import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {City} from '../../../models/city';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../../../services/facades/api/api.service";
import {Content} from "../../../models/content";
import {ContentStatus} from "../../../models/contentstatus";
import {ToastrService} from "ngx-toastr";
import {Point} from "../../../models/point";
import {point} from "leaflet";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
	selector: 'app-create-content',
	templateUrl: './create-content.component.html',
	styleUrls: ['./create-content.component.scss']
})
export class CreateContentComponent {
	city?: City;
	point?: Point;
	form: FormGroup;
	loading: Boolean = true;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.getCityDetail(id);
			this.getPointDetail(id, params["pointId"]);
		})
		this.form = fb.group({
			title: new FormControl('', [Validators.required, Validators.maxLength(50)]),
			description: new FormControl('', [Validators.required, Validators.maxLength(300)]),
			mediaUrl: new FormControl('', [Validators.required]),
			contestId: new FormControl('')
		});
	}

	createContent(): void {
		if (this.form.valid) {
			const content: Content = this.getContentFromForm();
			this.api.content.addContent(content, this.point!.cityId!).subscribe({
				next: (data) => {
					this.toastr.success('', 'Content created successfully');
					this.router.navigate(['city', this.point?.cityId, 'points', this.point?.id]);
				},
				error: (error: HttpErrorResponse) => {
					console.error('Error:', error.error);
					this.toastr.error(error.error, 'Error while creating content');
				}
			});
		}
	}

	getContentFromForm(): Content {
		if (this.form.valid && this.point) {
			return {
				title: this.form.get('title')?.value,
				description: this.form.get('description')?.value,
				publicationDate: new Date(),
				status: ContentStatus.DRAFT,
				authorId: this.api.auth.getUserInfo()?.id!,
				pointId: this.point.id!,
				mediaUrl: this.form.get('mediaUrl')?.value,
				contestId: this.form.get('contestId')?.value
			};
		} else {
			throw new Error('Form data is not valid');
		}
	}

	private getCityDetail(cityId: number) : void {
		this.api.city.getCityById(cityId).subscribe((city) => {
			this.city = city;
		})
	}

	private getPointDetail(cityId: number, pointId: number): void {
		this.api.point.getPointDetails(cityId, pointId).subscribe((point) => {
			this.point = point;
			this.loading = false;
		})
	}

}
