import {Routes} from "@angular/router"
import {LoginComponent} from "./components/auth/login/login.component"
import {SignupComponent} from "./components/auth/signup/signup.component"
import {HomeComponent} from "./components/home/home.component"
import {CityDetailComponent} from "./components/city-detail/city-detail.component"
import {ContactsComponent} from "./components/contacts/contacts.component"
import {PointsOfInterestComponent} from "./components/poi/points-of-interest/points-of-interest.component"
import {CreateContentComponent} from "./components/content/create-content/create-content.component"
import {CreatePoiComponent} from "./components/poi/create-poi/create-poi.component"
import {ContentDetailComponent} from "./components/content/content-detail/content-detail.component";
import {PointDetailComponent} from "./components/poi/point-detail/point-detail.component";
import {AreaDetailComponent} from "./components/area/area-detail/area-detail.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import { CreateContestComponent } from "./components/contest/create-contest/create-contest.component"

export const routes: Routes = [
	{path: "", redirectTo: "home", pathMatch: "full"},
	{path: "home", component: HomeComponent},
	{path: "login", component: LoginComponent},
	{path: "signup", component: SignupComponent},
	{path: "city/:id", component: CityDetailComponent},
	{path: "contacts", component: ContactsComponent},
	{path: "city/:id/create-content", component: CreateContentComponent},
	{path: "city/:id/create-poi", component: CreatePoiComponent},
	{path: "city/:id/create-area", component: CreateAreaComponent},
	{path: "city/:id/contents/:contentId", component: ContentDetailComponent},
	{path: "city/:id/points/:pointId", component: PointDetailComponent},
	{path: "city/:id/areas/:areaId", component: AreaDetailComponent},
	{path: "city/:id/create-contest", component: CreateContestComponent}
]
