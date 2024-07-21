import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FinancialData } from '../models/financial-data.model';

@Injectable({
  providedIn: 'root'
})
export class FinancialInfoService {
  private apiUrl = 'http://localhost:8080/api/financial';

  constructor(private http: HttpClient) { }

  getFinancialData(): Observable<FinancialData> {
    return this.http.get<FinancialData>(`${this.apiUrl}/data`);
  }

  saveFinancialData(data: FinancialData): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/save`, data);
  }
}
