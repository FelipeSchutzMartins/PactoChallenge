import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StorageService } from './storage.service';

const POSITIONS_API = 'http://localhost:8080/api/position/';

@Injectable({
  providedIn: 'root',
})
export class EmployerService {
  constructor(private http: HttpClient, private storageService : StorageService) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.storageService.getUser().token, 'Access-Control-Allow-Origin': 'http://localhost:4200'})
  };

  listAll(params: any): Observable<any> {
    return this.http.get(
      POSITIONS_API + 'list?' + 'page=0&size=3&sort=id,DESC',
      this.httpOptions
    );
  }
}
