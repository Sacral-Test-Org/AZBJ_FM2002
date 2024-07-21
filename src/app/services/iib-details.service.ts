import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IibDetails } from '../models/iib-details.model';
import { PolicyDetails } from '../models/policy-details.model';
import { PolicyDetail } from '../models/policy-detail.model';

@Injectable({
  providedIn: 'root'
})
export class IibDetailsService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {}

  getIibMatchedDetails(transactionId: string): Observable<IibDetails[]> {
    return this.http.get<IibDetails[]>(`${this.apiUrl}/iib-details/${transactionId}`);
  }

  getPolicyDetails(): Observable<PolicyDetails[]> {
    return this.http.get<PolicyDetails[]>(`${this.apiUrl}/policy-details`);
  }

  updatePolicyDetail(policyDetail: PolicyDetail): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/policy-details`, policyDetail);
  }
}
