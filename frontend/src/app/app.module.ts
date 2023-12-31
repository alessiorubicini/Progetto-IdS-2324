import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { environment } from '../environments/environment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { JwtModule } from '@auth0/angular-jwt';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter, RouterModule, RouterLinkActive } from '@angular/router';
import { routes } from './app.routes';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { OsmMapComponent } from './osm-map/osm-map.component';
import { CityDetailComponent } from './city-detail/city-detail.component';
import { ContactsComponent } from './contacts/contacts.component';
import { CreateContentComponent } from './create-content/create-content.component';
import { PointsOfInterestComponent } from './points-of-interest/points-of-interest.component';
import { AreasComponent } from './areas/areas.component';
import { ContestsComponent } from './contests/contests.component';
import { CreatePoiComponent } from './create-poi/create-poi.component';


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
    AreasComponent,
    ContestsComponent,
    CreatePoiComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
	ReactiveFormsModule,
	JwtModule.forRoot({
		config: {
		  tokenGetter: () => {
			return localStorage.getItem('access_token');
		  },
		  allowedDomains: [ environment.apiUrl ],
		  disallowedRoutes: [`${environment.apiUrl}/auth/login`]
		},
	  })
  ],
  providers: [provideHttpClient(), provideRouter(routes)],
  bootstrap: [AppComponent],
  exports : [RouterModule]
})
export class AppModule { }
