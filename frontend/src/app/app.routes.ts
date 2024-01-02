import { Routes } from "@angular/router"
import { LoginComponent } from "./login/login.component"
import { SignupComponent } from "./signup/signup.component"
import { HomeComponent } from "./home/home.component"
import { CityDetailComponent } from "./city-detail/city-detail.component"
import { ContactsComponent } from "./contacts/contacts.component"
import { PointsOfInterestComponent } from "./poi/points-of-interest/points-of-interest.component"
import { CreateContentComponent } from "./content/create-content/create-content.component"
import { CreatePoiComponent } from "./poi/create-poi/create-poi.component"

export const routes: Routes  = [
	{ path: "", redirectTo: "home", pathMatch: "full" },
	{ path: "home", component: HomeComponent },
	{ path: "login", component: LoginComponent },
	{ path: "signup", component: SignupComponent },
	{ path: "city/:id", component: CityDetailComponent },
	{ path: "contacts", component: ContactsComponent },
	{ path: "city/:id/create-content", component: CreateContentComponent},
	{ path: "city/:id/create-poi", component: CreatePoiComponent}
]