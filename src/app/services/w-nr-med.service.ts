import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WNrMedService {
  private apiUrl = 'http://localhost:8080/api/wnrmed';

  constructor(private http: HttpClient) {}

  setInsurancePolicyType(productId: number): Observable<any> {
    const url = `${this.apiUrl}/setInsurancePolicyType`;
    const body = { productId };
    return this.http.post<any>(url, body);
  }

  fetchDateFromAPI(): Observable<Date> {
    const url = `${this.apiUrl}/getSpecificDate`;
    return this.http.get<Date>(url);
  }

  updateReceiptStatus(receiptStatus: any): Observable<void> {
    const url = `${this.apiUrl}/updateReceiptStatus`;
    return this.http.post<void>(url, receiptStatus);
  }
}
