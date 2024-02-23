import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router'
import {City} from '../../../models/city';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Point} from "../../../models/point";
import {catchError, tap, throwError} from "rxjs";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {ToastrService} from "ngx-toastr";

@Component({
	selector: 'app-create-area',
	templateUrl: './create-area.component.html',
	styleUrls: ['./create-area.component.scss']
})
export class CreateAreaComponent {
	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			this.getCityDetail(id);
		})
		this.form = this.fb.group({
			name: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required, Validators.maxLength(180)]),
			imageUrl: new FormControl('', [Validators.required])
		});
	}

	getCityDetail(id: number): void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	createPoint(): void {
		if(this.form.valid) {
			const point: Point = this.getPointFromForm();
			this.api.point.addPoint(point).subscribe({
					next: (data) => {
						this.router.navigate(['city', this.city?.id]);
					},
					error: (error: HttpErrorResponse) => {
						console.error('Error:', error.error);
						this.toastr.error(error.error, 'Error while creating area');
					}
				});
		}
	}

	private getPointFromForm(): Point {
		if (!this.form.valid) throw new Error('Form data is not valid');
		return {
			name: this.form.get('name')?.value,
			description: this.form.get('description')?.value,
			imageUrl: this.form.get('imageUrl')?.value,
			cityId: this.city!.id!
		};
	}

}
