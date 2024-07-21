import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RiskScoreDetailsService {
  private baseUrl = 'http://localhost:8080/api/risk-score-details';

  constructor(private http: HttpClient) { }

  getRiskScoreDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }

  addRiskScoreDetail(riskScoreDetail: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}`, riskScoreDetail);
  }

  updateRiskScoreDetail(riskScoreDetail: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${riskScoreDetail.id}`, riskScoreDetail);
  }
}
