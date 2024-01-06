import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PointService } from '../../../services/point/point.service';
import { MockdataService } from '../../../services/mock/mockdata.service';
import { City } from '../../../models/city';
import { CityService } from '../../../services/city/city.service';
import {ApiService} from "../../../services/facades/api/api.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Point} from "../../../models/point";
import {ContentStatus} from "../../../models/contentstatus";

@Component({
  selector: 'app-create-poi',
  templateUrl: './create-poi.component.html',
  styleUrls: ['./create-poi.component.scss']
})
export class CreatePoiComponent {
	city?: City;
	form: FormGroup;

	constructor(private route: ActivatedRoute, public api: ApiService, private fb: FormBuilder) {
		this.route.params.subscribe(params => {
			const id = params["id"];
			//this.getCityDetail();
			this.city = MockdataService.getCityMock(id);
		});
		this.form = fb.group({
			title: new FormControl('', [Validators.required]),
			description: new FormControl('', [Validators.required]),
			mediaUrl: new FormControl('', [Validators.required])
		});
	}

	getCityDetail() : void {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			this.api.city.getCityById(cityId).subscribe((city) => {
				this.city = city;
			})
		})
	}

	createPoint() : void {
		if(this.form.valid) {
			const point: Point = this.getPointFromForm();
			// Send point to APIs
		}
	}

	getPointFromForm() : Point {
		if(this.form.valid && this.city) {
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


}
