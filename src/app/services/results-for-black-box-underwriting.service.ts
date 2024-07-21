import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Result } from '../models/result.model';

@Injectable({
  providedIn: 'root'
})
export class ResultsForBlackBoxUnderwritingService {
  private apiUrl = 'http://localhost:8080/api/results';

  constructor(private http: HttpClient) { }

  getResults(): Observable<Result[]> {
    return this.http.get<Result[]>(this.apiUrl);
  }
}
