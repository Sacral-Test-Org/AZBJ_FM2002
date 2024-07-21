import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class VerifiedAddressService {
  private apiUrl = 'http://localhost:8080/api/verify-address';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  verifyAddress(): Observable<any> {
    this.logger.debug('Verifying address');
    return this.http.post<any>(this.apiUrl, {});
  }
}
