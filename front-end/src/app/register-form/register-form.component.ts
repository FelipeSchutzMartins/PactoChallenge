import { Component, Input } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { StorageService } from '../_services/storage.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})

export class RegisterFormComponent {
  @Input() registerAs: string = '';
  form: any = {
    name: null,
    surname: null,
    companyName: null,
    username: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private storageService: StorageService) { }

  onSubmit(): void {
    const { name, surname, companyName, username, password } = this.form;

    this.authService.register(name, surname, companyName, username, password, this.registerAs).subscribe({
      next: data => {
        this.storageService.saveUser(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        window.location.reload();
      },
      error: err => {
        if (err.error == null) {
          this.errorMessage = "Ocorreu um erro desconhecido!"
        } else {
          this.errorMessage = err.error.erro;
        }
        this.isSignUpFailed = true;
      }
    });
  }
}
