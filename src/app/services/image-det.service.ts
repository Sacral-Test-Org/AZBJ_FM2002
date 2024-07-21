import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class ImageDetService {
  private apiUrl = 'http://localhost:8080/api/image-det';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getWebSalesProposalUrl(): Observable<string> {
    this.logger.debug('Calling getWebSalesProposalUrl endpoint');
    return this.http.get<string>(`${this.apiUrl}/web-sales-proposal-url`);
  }
}
