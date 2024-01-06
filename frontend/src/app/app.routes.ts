import {Routes} from "@angular/router"
import {LoginComponent} from "./components/auth/login/login.component"
import {SignupComponent} from "./components/auth/signup/signup.component"
import {HomeComponent} from "./components/home/home.component"
import {CityDetailComponent} from "./components/city-detail/city-detail.component"
import {ContactsComponent} from "./components/contacts/contacts.component"
import {CreateContentComponent} from "./components/content/create-content/create-content.component"
import {CreatePoiComponent} from "./components/poi/create-poi/create-poi.component"
import {ContentDetailComponent} from "./components/content/content-detail/content-detail.component";
import {PointDetailComponent} from "./components/poi/point-detail/point-detail.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import { CreateContestComponent } from "./components/contest/create-contest/create-contest.component"
import { ContestsDetailComponent } from "./components/contest/contests-detail/contests-detail.component"
import {UserProfileComponent} from "./components/user-profile/user-profile.component";

export const routes: Routes = [
	{path: "", redirectTo: "home", pathMatch: "full"},
	{path: "home", component: HomeComponent},
	{path: "login", component: LoginComponent},
	{path: "signup", component: SignupComponent},
	{path: "city/:id", component: CityDetailComponent},
	{path: "contacts", component: ContactsComponent},
	{path: "user/:id", component: UserProfileComponent},
	{path: "city/:id/points/:pointId/create-content", component: CreateContentComponent},
	{path: "city/:id/create-poi", component: CreatePoiComponent},
	{path: "city/:id/create-area", component: CreateAreaComponent},
	{path: "city/:id/points/:pointId/contents/:contentId", component: ContentDetailComponent},
	{path: "city/:id/points/:pointId", component: PointDetailComponent},
	{path: "city/:id/create-contest", component: CreateContestComponent},
	{path: "city/:id/contest-detail", component: ContestsDetailComponent}
	 //{path: "city/:id/contests/:contestId", component: ContestsDetailComponent}
]
