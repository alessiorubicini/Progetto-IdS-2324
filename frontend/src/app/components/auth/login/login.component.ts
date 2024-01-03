import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import {AuthService} from '../../../services/auth/auth.service';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.scss']
})
export class LoginComponent {

	form: FormGroup;
	passwordVisible: boolean = false;

	constructor(private router: Router, private authService: AuthService, private fb: FormBuilder) {
		this.form = fb.group({
			username: new FormControl('', [Validators.required]),
			password: new FormControl('', [Validators.required])
		});
	}

	login(): void {
		if (this.form.valid) {
			const username = this.form.get('username')!.value;
			const password = this.form.get('password')!.value;

			this.authService.login({"username": username, "password": password})
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

}
