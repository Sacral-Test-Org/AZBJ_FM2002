import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CounterOfferService {
  private baseUrl = 'http://localhost:8080/api/counter-offers';

  constructor(private http: HttpClient) {}

  getCounterOfferDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}/details`);
  }

  validateCounterOffer(selectedOfferType: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/validate`, { params: { offerType: selectedOfferType } });
  }

  generateLetter(): Observable<any> {
    return this.http.get(`${this.baseUrl}/generate-letter`);
  }

  generateBI(): Observable<any> {
    return this.http.get(`${this.baseUrl}/generate-bi`);
  }

  submitCounterOffer(counterOfferDetails: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit`, counterOfferDetails);
  }

  checkProductAndGroupStatus(productId: string, groupId: string): Observable<{ productLinkedToUnit: boolean, groupProductStatus: string }> {
    return this.http.get<{ productLinkedToUnit: boolean, groupProductStatus: string }>(`${this.baseUrl}/check-status`, { params: { productId, groupId } });
  }
}