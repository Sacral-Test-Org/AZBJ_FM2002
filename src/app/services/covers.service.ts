import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoversService {
  private baseUrl = 'http://localhost:8080/api/covers';

  constructor(private http: HttpClient) { }

  // Method to fetch data related to the 'Cash Bonus' field
  getCashBonusData(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/cash-bonus`);
  }

  // Method to update data related to the 'Cash Bonus' field
  updateCashBonusData(data: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/cash-bonus`, data);
  }
}
