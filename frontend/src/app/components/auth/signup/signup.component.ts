import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../../services/auth/auth.service';
import {User} from '../../../models/user';
import {ToastrService} from "ngx-toastr";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
	selector: 'app-signup',
	templateUrl: './signup.component.html',
	styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
	form: FormGroup;
	passwordVisible: boolean = false;

	constructor(private router: Router, private authService: AuthService, private fb: FormBuilder, private toastrService: ToastrService) {
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
			validators: [this.validatePasswordMatching, this.validateFiscalCode]
		});
	}

	validatePasswordMatching(control: AbstractControl) {
		const password1 = control.get('password1')?.value;
		const password2 = control.get('password2')?.value
		if(password1 && password2 && password1 != password2) {
			return { 'notSame': true };
		}
		return null;
	}

	validateFiscalCode(control: AbstractControl) {
		const fiscalCode = control.get('fiscalCode')?.value;
		const regex = /^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/;
		if(fiscalCode && !regex.test(fiscalCode)) {
			return { 'invalidFiscalCode': true };
		}
		return null;
	}

	get password1() { return this.form.get('password1'); }
	get password2() { return this.form.get('password2'); }
	get fiscalCode() { return this.form.get('fiscalCode'); }

	signup(): void {
		const user: User = this.getUserFromForm();
		this.authService.signup(user)
			.subscribe({
				next: (result) => {
					console.log('Signup successful:', result);
					this.router.navigate(['/login']);
				},
				error: (error: HttpErrorResponse) => {
					alert(`Signup failed: ${error.error}`);
				},
				complete: () => {
					console.log('Signup completed');
				}
			});
	}

	getUserFromForm(): User {
		if (!this.form.valid) throw new Error('Form data is not valid');
		return {
			name: this.form.get('name')?.value,
			surname: this.form.get('surname')?.value,
			username: this.form.get('username')?.value,
			fiscalCode: this.form.get('fiscalCode')?.value,
			email: this.form.get('email')?.value,
			password: this.form.get('password1')?.value,
		};
	}
}
