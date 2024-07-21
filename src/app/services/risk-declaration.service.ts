import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RiskDeclaration } from '../models/risk-declaration.model';

@Injectable({
  providedIn: 'root'
})
export class RiskDeclarationService {
  private apiUrl = 'http://localhost:8080/api/risk-declarations';

  constructor(private http: HttpClient) {}

  getRiskDeclarations(): Observable<RiskDeclaration[]> {
    return this.http.get<RiskDeclaration[]>(this.apiUrl);
  }

  saveSelectedValue(selectedValue: number): Observable<any> {
    const url = `${this.apiUrl}/save-selected-value`;
    return this.http.post<any>(url, { selectedValue });
  }
}
