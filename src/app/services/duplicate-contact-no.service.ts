import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DuplicateContactNoService {
  private apiUrl = 'http://localhost:8080/api/duplicate-contacts'; // URL to web API

  constructor(private http: HttpClient) { }

  getDuplicateContacts(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
