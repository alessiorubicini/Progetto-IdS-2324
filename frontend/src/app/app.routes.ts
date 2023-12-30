import { Routes } from "@angular/router"
import { LoginComponent } from "./login/login.component"
import { SignupComponent } from "./signup/signup.component"
import { HomeComponent } from "./home/home.component"
import { CityDetailComponent } from "./city-detail/city-detail.component"
import { ContactsComponent } from "./contacts/contacts.component"

export const routes: Routes  = [
	{ path: "", redirectTo: "home", pathMatch: "full" },
	{ path: "home", component: HomeComponent },
	{ path: "login", component: LoginComponent },
	{ path: "signup", component: SignupComponent },
	{ path: "city/:id", component: CityDetailComponent },
	{ path: "contacts", component: ContactsComponent }
	
]