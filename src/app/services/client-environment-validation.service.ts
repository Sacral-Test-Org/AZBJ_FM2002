import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidationRequest } from '../models/validation-request.model';
import { ValidationResponse } from '../models/validation-response.model';
import { ManualCasePushDTO } from '../models/manual-case-push-dto.model';

@Injectable({
  providedIn: 'root'
})
export class ClientEnvironmentValidationService {
  private baseUrl = 'http://localhost:8080/api/client-environment-validation';

  constructor(private http: HttpClient) {}

  validatePartnerReferences(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/validatePartnerReferences`);
  }

  validatePolicy(validationRequest: ValidationRequest): Observable<ValidationResponse> {
    return this.http.post<ValidationResponse>(`${this.baseUrl}/validatePolicy`, validationRequest);
  }

  getManualCasePushMessages(applicationNumber: string): Observable<ManualCasePushDTO> {
    return this.http.get<ManualCasePushDTO>(`${this.baseUrl}/manualCasePushMessages/${applicationNumber}`);
  }
}
