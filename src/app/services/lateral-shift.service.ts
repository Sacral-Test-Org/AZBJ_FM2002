import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class LateralShiftService {
  private baseUrl = 'http://localhost:8080/api/lateral-shift';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  fetchOldProductData(): Observable<any> {
    this.logger.debug('Fetching old product data from the back-end');
    return this.http.get<any>(`${this.baseUrl}/old-product-data`);
  }
}