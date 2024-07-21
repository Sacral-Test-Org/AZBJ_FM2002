import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PolicyMember } from '../models/policy-member.model';
import { LoadingDetails } from '../models/loading-details.model';

@Injectable({
  providedIn: 'root'
})
export class PolicyMemberLoadingDetailsService {
  private policyMemberUrl = 'api/policy-members';
  private loadingDetailsUrl = 'api/loading-details';

  constructor(private http: HttpClient) {}

  getPolicyMemberDetails(): Observable<any> {
    return this.http.get<any>(this.policyMemberUrl);
  }

  updateRelation(relation: string): Observable<any> {
    return this.http.post<any>(`${this.policyMemberUrl}/update-relation`, { relation });
  }

  getPolicyMemberRecords(): Observable<PolicyMember[]> {
    return this.http.get<PolicyMember[]>(this.policyMemberUrl);
  }

  getLoadingDetailsRecords(): Observable<LoadingDetails[]> {
    return this.http.get<LoadingDetails[]>(this.loadingDetailsUrl);
  }

  addLoadingDetailsRecord(policyMember: PolicyMember): Observable<void> {
    return this.http.post<void>(this.loadingDetailsUrl, policyMember);
  }
}