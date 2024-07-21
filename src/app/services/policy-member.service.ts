import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyMemberService {
  private apiUrl = 'http://localhost:8080/api/policy-members';

  constructor(private http: HttpClient) {}

  addMember(memberDetails: object): Observable<any> {
    return this.http.post(`${this.apiUrl}/add`, memberDetails);
  }

  deleteMember(memberId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${memberId}`);
  }

  validateMember(memberDetails: object): Observable<any> {
    return this.http.post(`${this.apiUrl}/validate`, memberDetails);
  }

  declineMember(memberId: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/decline`, { memberId });
  }

  loadMemberDetails(memberId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/details/${memberId}`);
  }

  fetchPartnerList(): Observable<any> {
    return this.http.get(`${this.apiUrl}/partners`);
  }

  getCoverCode(relation: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/cover-code/${relation}`);
  }

  queryHniPolicies(): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiUrl}/hni-policies`);
  }

  checkPreviousLapsePolicies(): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiUrl}/previous-lapse-policies`);
  }

  updateWeightChange(weightChange: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/update-weight-change`, { weightChange });
  }

  updateFormStatus(formStatus: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/update-form-status`, { formStatus });
  }

  getAgeProofDetails(proofType: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/age-proof/${proofType}`);
  }

  calculateSumAssured(request: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/calculate-sum-assured`, request);
  }

  savePolicyMember(policyMember: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/save`, policyMember);
  }

  getPolicyMemberDetails(policyMemberId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/details/${policyMemberId}`);
  }

  updateLateralShiftStatus(lateralShiftDTO: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/update-lateral-shift`, lateralShiftDTO);
  }

  fetchValidAgeProofTypes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/valid-age-proofs`);
  }

  validateBMI(bmiData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/validate-bmi`, bmiData);
  }

  validateHeight(height: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/validate-height`, { height });
  }
}
