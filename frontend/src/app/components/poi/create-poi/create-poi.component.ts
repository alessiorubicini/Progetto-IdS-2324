import {Component, Input} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MockdataService} from '../../../services/mock/mockdata.service';
import {City} from '../../../models/city';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Point} from "../../../models/point";
import {catchError, Observable, tap, throwError} from "rxjs";
import {HttpResponse} from "@angular/common/http";

@Component({
	selector: 'app-create-poi',
	templateUrl: './create-poi.component.html',
	styleUrls: ['./create-poi.component.scss']
})
export class CreatePoiComponent {
	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.getCityDetail(cityId);
		});
		this.form = fb.group({
			name: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required, Validators.maxLength(300)]),
			longitude: new FormControl('', [Validators.required]),
			latitude: new FormControl('', [Validators.required]),
			altitude: new FormControl('', [Validators.required]),
			imageUrl: new FormControl('', [Validators.required, Validators.pattern('https?://.+')])
		});

	}

	createPoint(): void {
		if (this.form.valid) {
			const point: Point = this.getPointFromForm();
			console.log("Created point: " + point)
			this.api.point.addPoint(point).subscribe((response) => {
				console.log(response)
				if (response.status === 200) {
					this.router.navigate(['../']);
				}
			})
		} else {
			console.log("Form not valid")
		}
	}

	getPointFromForm(): Point {
		if (this.form.valid && this.city) {
			return {
				name: this.form.get('name')?.value,
				description: this.form.get('description')?.value,
				longitude: this.form.get('longitude')?.value,
				latitude: this.form.get('latitude')?.value,
				altitude: this.form.get('altitude')?.value,
				imageUrl: this.form.get('imageUrl')?.value,
				cityId: this.city.id!
			};
		} else {
			throw new Error('Form data is not valid');
		}
	}

	getCityDetail(id: number): void {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}



}
