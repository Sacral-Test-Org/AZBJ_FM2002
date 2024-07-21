import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class PanApprovalService {
  private baseUrl = 'http://localhost:8080/api/pan-approval';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  approvePAN(formData: any): Observable<any> {
    this.logger.debug('Approving PAN with data:', formData);
    return this.http.post(`${this.baseUrl}/approve`, formData);
  }

  saveApprovalStatus(approvalStatus: string): Observable<any> {
    this.logger.debug('Saving approval status:', approvalStatus);
    return this.http.post(`${this.baseUrl}/save-status`, { status: approvalStatus });
  }

  getPanApprovalDetails(): Observable<any> {
    this.logger.debug('Fetching PAN approval details');
    return this.http.get(`${this.baseUrl}/details`);
  }
}
