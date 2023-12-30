import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

	form: FormGroup;
	passwordVisible: boolean = false;
	authService: AuthService;
	passwordsMatchError: boolean = false;
  
	constructor(private router: Router, authService: AuthService, fb: FormBuilder) {
		this.form = fb.group({
			name: new FormControl('', [Validators.required]),
			surname: new FormControl('', [Validators.required]),
			username: new FormControl('', [Validators.required]),
			email: new FormControl('', [Validators.required, Validators.email]),
			password1: new FormControl('', [Validators.required]),
      		password2: new FormControl('', [Validators.required])
		});
		
		this.authService = authService;
	}

	signup() : void {
		if(this.form.valid && !this.passwordsMatchError) {
			// TODO: creare oggetto User e mandarlo alle API
		}
	}

	// TODO: aggiungere validazione conferma password

	/*
	private passwordsMatchValidator(control: AbstractControl): ValidationErrors | null {
		const password1 = control.get('password1')?.value;
		const password2 = control.get('password2')?.value;
		this.passwordsMatchError = password1 !== password2;
		if (password1 !== password2) {
		  return { passwordsNotMatch: true };
		}
		return null;
	}*/

}
