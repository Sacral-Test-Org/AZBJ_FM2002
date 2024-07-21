import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortfolioStrategy } from '../models/portfolio-strategy.model';

@Injectable({
  providedIn: 'root'
})
export class AllocationService {
  private baseUrl = 'http://localhost:8080/api/allocation';

  constructor(private http: HttpClient) {}

  deleteFund(fundId: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteFund/${fundId}`);
  }

  populateAllocation(): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/populateAllocation`, {});
  }

  getPortfolioStrategy(): Observable<PortfolioStrategy> {
    return this.http.get<PortfolioStrategy>(`${this.baseUrl}/portfolioStrategy`);
  }

  validateDiscountType(discountType: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/validateDiscountType`, { discountType });
  }

  getFundDetails(portfolioStrategy: string, productId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/fundDetails`, {
      params: { portfolioStrategy, productId }
    });
  }

  populateFunds(portfolioStrategy: string, productId: number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/populateFunds`, { portfolioStrategy, productId });
  }

  autoPopulateFunds(productId: number, portfolioStrategy: string): void {
    this.http.post<void>(`${this.baseUrl}/autoPopulateFunds`, { productId, portfolioStrategy }).subscribe();
  }
}
