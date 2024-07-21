import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PolicyDetailsDTO } from '../models/policy-details-dto.model';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class PolicyDetailsService {
  private apiUrl = 'http://localhost:8080/api/policy-details';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getPolicyDetails(insuredPersonId: string): Observable<PolicyDetailsDTO> {
    this.logger.debug('Fetching policy details for insuredPersonId:', insuredPersonId);
    return this.http.get<PolicyDetailsDTO>(`${this.apiUrl}/${insuredPersonId}`).pipe(
      catchError((error) => {
        this.logger.error('Error fetching policy details:', error);
        throw error;
      })
    );
  }
}
