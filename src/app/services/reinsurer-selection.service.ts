import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReinsurerSelectionService {
  private baseUrl = 'http://localhost:8080/api/reinsurer';

  constructor(private http: HttpClient) { }

  getReinsurerData(): Observable<any> {
    return this.http.get(`${this.baseUrl}/data`);
  }

  getReinsuranceCoverDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}/cover-details`);
  }

  deleteReinsuranceCoverDetail(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/cover-details/${id}`);
  }

  deleteRecord(recordId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/record/${recordId}`);
  }

  getReinsurerCodes(reinsuranceType: string, productId: string, coverCode: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/reinsurer-codes`, {
      params: {
        reinsuranceType,
        productId,
        coverCode
      }
    });
  }
}
