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
	point?: Point;
	loading: Boolean = true;

	constructor(private route: ActivatedRoute, private router: Router, public api: ApiService, private fb: FormBuilder, public toastr: ToastrService) {
		this.route.params.subscribe(params => {
			const cityId = params["id"];
			const pointId = params["pointId"];
			this.getPointDetail(cityId, pointId);
		})
	}

	getPointDetail(cityId: number, pointId: number) {
		this.api.point.getPointDetails(cityId, pointId).subscribe((point) => {
			this.point = point;
			this.loading = false;
		})
	}

	deletePoint() {
		this.api.point.deletePoint(this.point?.cityId!, this.point?.id!).subscribe({
			next: (data) => {
				this.toastr.success('', 'Point deleted successfully');
				this.router.navigate(['city', this.point?.cityId!]);
			},
			error: (error) => {
				this.toastr.error(error, 'Error while deleting point');
			}
		});
	}
}
