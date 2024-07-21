import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AgeCalculationRequest, AgeCalculationResponse } from './age-calculation.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class AgeCalculationService {
  private apiUrl = 'http://localhost:8080/api/age-calculation';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  calculateAge(dateOfBirth: Date, inceptionDate: Date): Observable<AgeCalculationResponse> {
    const request: AgeCalculationRequest = { dateOfBirth, inceptionDate };
    this.logger.debug('Calculating age with request:', request);
    return this.http.post<AgeCalculationResponse>(this.apiUrl, request);
  }
}
