import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReinsuranceDetails } from '../models/reinsurance-details.model';
import { ReinsurerDetails } from '../models/reinsurer-details.model';
import { ReinsuranceDetailsDTO } from '../models/reinsurance-details-dto.model';

@Injectable({
  providedIn: 'root'
})
export class ReinsuranceDetailsService {
  private apiUrl = '/api/reinsurance-details';

  constructor(private http: HttpClient) {}

  getReinsuranceDetails(): Observable<ReinsuranceDetails[]> {
    return this.http.get<ReinsuranceDetails[]>(`${this.apiUrl}`);
  }

  getReinsurerDetails(): Observable<ReinsurerDetails[]> {
    return this.http.get<ReinsurerDetails[]>(`${this.apiUrl}/reinsurer-details`);
  }

  referToReinsurer(details: ReinsurerDetails): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/refer`, details);
  }

  saveReinsuranceDetails(details: ReinsuranceDetailsDTO): Observable<ReinsuranceDetailsDTO> {
    return this.http.post<ReinsuranceDetailsDTO>(`${this.apiUrl}/save`, details);
  }

  deleteRecord(recordId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${recordId}`);
  }

  getReinsurerCodes(reinsuranceType: string, productId: string): Observable<ReinsurerDetails[]> {
    return this.http.get<ReinsurerDetails[]>(`${this.apiUrl}/reinsurer-codes`, {
      params: { reinsuranceType, productId }
    });
  }
}
