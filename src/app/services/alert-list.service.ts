import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidationResponse } from '../models/validation-response.model';

@Injectable({
  providedIn: 'root'
})
export class AlertListService {
  private apiUrl = 'http://localhost:8080/api/validate-options';

  constructor(private http: HttpClient) {}

  validateOptions(options: { backdating: string, dispatch: string, receipt: string, premium: string, rider: string, excessPremium: string, mobile: string }): Observable<ValidationResponse> {
    return this.http.post<ValidationResponse>(this.apiUrl, options);
  }
}