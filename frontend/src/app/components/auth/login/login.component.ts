import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

	form: FormGroup;
	passwordVisible: boolean = false;
	authService: AuthService

	constructor(private router: Router, authService: AuthService, fb: FormBuilder) {
		this.form = fb.group({
			username: new FormControl('', [Validators.required]),
			password: new FormControl('', [Validators.required])
		  });
		this.authService = authService;
	}


	login(): void {
	  if (this.form.valid) {
		const username = this.form.get('username')!.value;
      	const password = this.form.get('password')!.value;

		this.authService.login({ "username": username, "password": password})
		.subscribe({
			next: (result) => {
				console.log('Login successful:', result);
				// Redirect to home
				this.router.navigate(['/home']);
			},
			error: (error) => {
				console.error('Login failed:', error);
			},
			complete: () => {
				console.error('Login completed');
			}
		});

	  }
	}

	resetPassword(): void {
	  // Redirect to password reset page
	  this.router.navigate(['/forgot-password']);
	}

	signUp(): void {
	  // Redirect to sign up page
	  this.router.navigate(['/signup']);
	}

}
