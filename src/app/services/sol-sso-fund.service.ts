import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class SolSsoFundService {
  private baseUrl = 'http://localhost:8080/api/sol-sso-fund';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  validateApportionment(productId: number, fundId: string, apportionmentPercentage: number): Observable<any> {
    this.logger.debug('Validating apportionment', { productId, fundId, apportionmentPercentage });
    return this.http.post<any>(`${this.baseUrl}/validate-apportionment`, { productId, fundId, apportionmentPercentage });
  }

  fetchFunds(productId: string, dateRange: string, coverCode: string): Observable<Fund[]> {
    this.logger.debug('Fetching funds', { productId, dateRange, coverCode });
    return this.http.get<Fund[]>(`${this.baseUrl}/funds`, { params: { productId, dateRange, coverCode } });
  }
}

export interface Fund {
  fundShortName: string;
  fundFullName: string;
}
