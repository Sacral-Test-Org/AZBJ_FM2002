import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommissionDetails } from '../models/commission-details.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class CommissionDetailsService {
  private apiUrl = 'http://localhost:8080/api/commissions';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getCommissionDetails(agentCode: string): Observable<CommissionDetails> {
    this.logger.debug('Fetching commission details for agent code:', agentCode);
    return this.http.get<CommissionDetails>(`${this.apiUrl}/${agentCode}`);
  }
}
