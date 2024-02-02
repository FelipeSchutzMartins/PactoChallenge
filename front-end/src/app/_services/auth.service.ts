import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StorageService } from './storage.service';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'http://localhost:4200'})
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient, private storageService : StorageService) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signin',
      {
        email,
        password,
      },
      httpOptions
    );
  }

  register(name: string, surname: string, companyName: string, email: string, password: string, registerAs: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'signupAs' + registerAs,
      {
        name,
        surname,
        companyName,
        email,
        password,
      },
      httpOptions
    );
  }

  logout() {
    this.storageService.removeUser()
  }
}
