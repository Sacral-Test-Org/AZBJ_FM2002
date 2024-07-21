import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Proposal } from '../models/proposal.model';

@Injectable({
  providedIn: 'root'
})
export class SimultaneousProposalsService {
  private apiUrl = 'http://your-api-url/simultaneous-proposals';

  constructor(private http: HttpClient) { }

  getProposals(): Observable<Proposal[]> {
    return this.http.get<Proposal[]>(this.apiUrl);
  }
}
