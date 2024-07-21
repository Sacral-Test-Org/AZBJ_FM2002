import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class DiscountTypeService {
  private apiUrl = 'http://localhost:8080/api/discount-type';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getDiscountType(): Observable<any> {
    this.logger.debug('Requesting discount type from backend');
    return this.http.get<any>(this.apiUrl);
  }
}
