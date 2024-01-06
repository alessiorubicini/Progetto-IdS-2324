import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {environment} from '../environments/environment';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {JwtModule} from '@auth0/angular-jwt';
import {HTTP_INTERCEPTORS, provideHttpClient} from '@angular/common/http';
import {provideRouter, RouterModule} from '@angular/router';
import {routes} from './app.routes';
import {LoginComponent} from './components/auth/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SignupComponent} from './components/auth/signup/signup.component';
import {HomeComponent} from './components/home/home.component';
import {OsmMapComponent} from './components/osm-map/osm-map.component';
import {CityDetailComponent} from './components/city-detail/city-detail.component';
import {ContactsComponent} from './components/contacts/contacts.component';
import {CreateContentComponent} from './components/content/create-content/create-content.component';
import {PointsOfInterestComponent} from './components/poi/points-of-interest/points-of-interest.component';
import {CreatePoiComponent} from './components/poi/create-poi/create-poi.component';
import {ContestsDetailComponent} from './components/contest/contests-detail/contests-detail.component';
import {CreateContestComponent} from './components/contest/create-contest/create-contest.component';
import {ContestListComponent} from './components/contest/contest-list/contest-list.component';
import {PointDetailComponent} from './components/poi/point-detail/point-detail.component';
import {CreateAreaComponent} from './components/area/create-area/create-area.component';
import {ContentDetailComponent} from './components/content/content-detail/content-detail.component';
import {ContentListComponent} from './components/content/content-list/content-list.component';
import {AreasListComponent} from './components/area/areas-list/areas-list.component';
import {ToastrModule} from 'ngx-toastr';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import {HeaderInterceptor} from "./services/interceptors/header-interceptor";

@NgModule({
	declarations: [
		AppComponent,
		LoginComponent,
		SignupComponent,
		HomeComponent,
		OsmMapComponent,
		CityDetailComponent,
		ContactsComponent,
		CreateContentComponent,
		PointsOfInterestComponent,
		CreatePoiComponent,
		ContestsDetailComponent,
		CreateContestComponent,
		ContestListComponent,
		PointDetailComponent,
		CreateAreaComponent,
		ContentDetailComponent,
		ContentListComponent,
		AreasListComponent,
  UserProfileComponent,
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		NgbModule,
		ReactiveFormsModule,
		ToastrModule.forRoot(),
		JwtModule.forRoot({
			config: {
				tokenGetter: () => {
					return localStorage.getItem('access_token');
				},
				allowedDomains: [environment.apiUrl],
				disallowedRoutes: [`${environment.apiUrl}/auth/login`]
			},
		}),
		FormsModule
	],
	providers: [provideHttpClient(), provideRouter(routes), {
		provide: HTTP_INTERCEPTORS,
		useClass: HeaderInterceptor,
		multi: true
	}],
	bootstrap: [AppComponent],
	exports: [RouterModule]
})
export class AppModule {
}
