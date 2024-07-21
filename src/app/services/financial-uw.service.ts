import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FinancialUwDTO } from '../models/financial-uw.dto';

@Injectable({
  providedIn: 'root'
})
export class FinancialUwService {
  private apiUrl = '/api/financial-uw';

  constructor(private http: HttpClient) {}

  getFinancialDetails(): Observable<FinancialUwDTO[]> {
    return this.http.get<FinancialUwDTO[]>(this.apiUrl);
  }

  saveFinancialDetails(financialDetails: FinancialUwDTO): Observable<void> {
    return this.http.post<void>(this.apiUrl, financialDetails);
  }
}
