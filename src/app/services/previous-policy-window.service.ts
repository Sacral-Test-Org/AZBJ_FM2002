import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PreviousDecision } from '../models/previous-decision.model';
import { PreviousPolicyDetailsDTO } from '../models/previous-policy-details-dto.model';

@Injectable({
  providedIn: 'root'
})
export class PreviousPolicyWindowService {
  private baseUrl = 'http://localhost:8080/api'; // Base URL for the backend API

  constructor(private http: HttpClient) {}

  fetchPreviousDecisions(): Observable<PreviousDecision[]> {
    return this.http.get<PreviousDecision[]>(`${this.baseUrl}/previous-decisions`);
  }

  getPreviousPolicyDetails(customerId: string): Observable<PreviousPolicyDetailsDTO[]> {
    return this.http.get<PreviousPolicyDetailsDTO[]>(`${this.baseUrl}/previous-policies/${customerId}`);
  }
}