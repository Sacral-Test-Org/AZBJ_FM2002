import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RiCommentsService {
  private apiUrl = 'http://localhost:8080/api/comments'; // URL to web api

  constructor(private http: HttpClient) { }

  getPreviousComments(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
