import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../../services/auth/auth.service';
import {User} from '../../../models/user';

@Component({
	selector: 'app-signup',
	templateUrl: './signup.component.html',
	styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

	form: FormGroup;
	passwordVisible: boolean = false;

	constructor(private router: Router, private authService: AuthService, private fb: FormBuilder) {
		this.form = this.fb.group({
			name: ['', [Validators.required]],
			surname: ['', [Validators.required]],
			username: ['', [Validators.required]],
			email: ['', [Validators.required, Validators.email]],
			fiscalCode: ['', [Validators.required]],
			password1: ['', [Validators.required, Validators.minLength(8)]],
			password2: ['', [Validators.required]],
			termsAndConditions: [false, Validators.requiredTrue],
			privacyPolicy: [false, Validators.requiredTrue]
		}, {
			validator: this.checkPasswordMatching
		});
	}

	// TODO: password matching check not working!
	checkPasswordMatching(group: FormGroup) {
		const password1 = group.get('password1')?.value;
		const password2 = group.get('password2')?.value
		return password1 === password2 ? null : { notSame: true };
	}

	signup(): void {
		const user: User = this.getUserFromForm();
		this.authService.signup(user).subscribe({
				next: (result) => {
					this.router.navigate(['/login']);
				},
				error: (error) => {
					console.error('Signup failed:', error);
				},
				complete: () => {
					console.error('Signup completed');
				}
			});
	}

	getUserFromForm(): User {
		if (!this.form.valid) {
			throw new Error('Form data is not valid');
		}
		return {
			name: this.form.get('name')?.value,
			surname: this.form.get('surname')?.value,
			username: this.form.get('username')?.value,
			fiscalCode: this.form.get('fiscalCode')?.value,
			email: this.form.get('email')?.value,
			password: this.form.get('password1')?.value,
		};
	}

	get password1() { return this.form.get('password1'); }
	get password2() { return this.form.get('password2'); }
}
