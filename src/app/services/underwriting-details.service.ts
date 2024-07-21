import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UnderwritingDetail } from '../models/underwriting-detail.model';

@Injectable({
  providedIn: 'root'
})
export class UnderwritingDetailsService {
  private apiUrl = 'http://localhost:8080/api/underwriting-details';

  constructor(private http: HttpClient) { }

  getUnderwritingDetails(): Observable<UnderwritingDetail[]> {
    return this.http.get<UnderwritingDetail[]>(this.apiUrl);
  }

  addUnderwritingDetail(detail: UnderwritingDetail): Observable<UnderwritingDetail> {
    return this.http.post<UnderwritingDetail>(this.apiUrl, detail);
  }

  updateUnderwritingDetail(detail: UnderwritingDetail): Observable<UnderwritingDetail> {
    return this.http.put<UnderwritingDetail>(`${this.apiUrl}/${detail.id}`, detail);
  }
}
