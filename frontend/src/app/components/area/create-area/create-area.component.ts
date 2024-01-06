import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router'
import {City} from '../../../models/city';
import {MockdataService} from '../../../services/mock/mockdata.service';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Point} from "../../../models/point";
import {catchError, tap, throwError} from "rxjs";
import {HttpResponse} from "@angular/common/http";

@Component({
	selector: 'app-create-area',
	templateUrl: './create-area.component.html',
	styleUrls: ['./create-area.component.scss']
})
export class CreateAreaComponent {
	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router, private api: ApiService, private fb: FormBuilder) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			//this.getCityDetail();
			this.city = MockdataService.getCityMock(id);
		})
		this.form = fb.group({
			name: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required]),
			imageUrl: new FormControl('', [Validators.required])
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

	createPoint(): void {
		if(this.form.valid) {
			const point: Point = this.getPointFromForm();
			this.api.point.addPoint(point).pipe(tap((response: HttpResponse<any>) => {
					if(response.status === 200) {
						this.router.navigate(['../']);
					}
				}),
				catchError(error => {
					console.error('Signup failed. Error:', error);
					return throwError(() => error);
				})
			);
		}
	}

	private getPointFromForm(): Point {
		if (!this.form.valid) throw new Error('Form data is not valid');
		return {
			name: this.form.get('name')?.value,
			description: this.form.get('description')?.value,
			imageUrl: this.form.get('imageUrl')?.value,
			cityId: this.city?.id!
		};
	}
}
