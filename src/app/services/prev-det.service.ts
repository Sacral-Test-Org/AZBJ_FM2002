import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Decision } from '../models/decision.model';

@Injectable({
  providedIn: 'root'
})
export class PrevDetService {
  private apiUrl = 'http://localhost:8080/api/decisions';

  constructor(private http: HttpClient) { }

  getPreviousDecisions(): Observable<Decision[]> {
    return this.http.get<Decision[]>(this.apiUrl);
  }
}
