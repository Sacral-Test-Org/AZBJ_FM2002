import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecFrarReqService {
  private baseUrl = 'http://localhost:8080/api/sec-frar-req';

  constructor(private http: HttpClient) { }

  getFrarRequirements(): Observable<any> {
    return this.http.get(`${this.baseUrl}/requirements`);
  }

  saveComments(comments: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-comments`, { comments });
  }

  authenticate(supervisorId: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/authenticate`, { supervisorId, password });
  }

  getLOVValues(testNumber: string): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/lov-values/${testNumber}`);
  }

  getReasonDescription(reason: number): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/reason-description/${reason}`);
  }

  approveRequest(supervisorId: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/approve-request`, { supervisorId, password });
  }
}
