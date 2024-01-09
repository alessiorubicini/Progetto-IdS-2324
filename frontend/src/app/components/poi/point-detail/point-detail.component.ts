import { Component } from '@angular/core';
import {Point} from "../../../models/point";
import {Content} from "../../../models/content";
import {City} from "../../../models/city";
import {ApiService} from "../../../services/facades/api/api.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-point-detail',
  templateUrl: './point-detail.component.html',
  styleUrls: ['./point-detail.component.scss']
})
export class PointDetailComponent {
	city?: City
	point?: Point;
	contents?: Content[];

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const pointId = params["pointId"];
			this.getCityDetail(cityId);
			this.getPointDetail(pointId);
			this.getContentsOfPoint(pointId);
		})
	}

	getCityDetail(id: number) {
		this.api.city.getCityById(id).subscribe((city) => {
			this.city = city;
		})
	}

	getPointDetail(id: number) {
		this.api.point.getPointDetails(id).subscribe((point) => {
			this.point = point;
		})
	}

	getContentsOfPoint(id: number) {
		this.api.point.getContentsOfPoint(id).subscribe((contents) => {
			this.contents = contents;
		})
	}

	removePoint() {
		this.api.point.removePoint(this.point!.id!).subscribe({
			next: (data) => {
				this.toastr.success('', 'Point deleted successfully');
				this.router.navigate(['city', this.city?.id]);
			},
			error: (error) => {
				this.toastr.error(error, 'Error while deleting point');
			}
		});;
	}
}
