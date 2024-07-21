import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReinsuranceCoverDetailsService {
  private baseUrl = 'http://localhost:8080/api/reinsurance';

  constructor(private http: HttpClient) {}

  getCalculatedValues(): Observable<any> {
    return this.http.get(`${this.baseUrl}/calculated-values`);
  }

  validateMedicalLoadingPercentage(coverCode: string, medicalLoadingPercentage: number, productDefinition: string, nonResidentInsurancePercentage: number): Observable<any> {
    const params = { coverCode, medicalLoadingPercentage, productDefinition, nonResidentInsurancePercentage };
    return this.http.post(`${this.baseUrl}/validate-medical-loading`, params);
  }

  calculateReinsuranceAmount(reinsurancePercentage: number, coverAmount: number): Observable<number> {
    const params = { reinsurancePercentage, coverAmount };
    return this.http.post<number>(`${this.baseUrl}/calculate-reinsurance-amount`, params);
  }

  getCoverCodes(): Observable<any> {
    return this.http.get(`${this.baseUrl}/cover-codes`);
  }
}
