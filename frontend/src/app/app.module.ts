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


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent
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
  bootstrap: [AppComponent]
})
export class AppModule { }
