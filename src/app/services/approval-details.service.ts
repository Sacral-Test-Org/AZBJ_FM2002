import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApprovalDetails } from '../models/approval-details.model';

@Injectable({
  providedIn: 'root'
})
export class ApprovalDetailsService {
  private apiUrl = 'http://localhost:8080/api/approval-details';

  constructor(private http: HttpClient) { }

  getApprovalDetails(): Observable<ApprovalDetails> {
    return this.http.get<ApprovalDetails>(this.apiUrl);
  }
}
