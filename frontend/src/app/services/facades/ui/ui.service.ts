import { Injectable } from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
// This is a facade single interface to the variety of Angular UI services
export class UiService {

  constructor(public router: Router, public route: ActivatedRoute, public toastr: ToastrService, public title: Title) { }
}
