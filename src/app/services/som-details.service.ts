import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HubInchargeDetailsDTO } from '../models/hub-incharge-details.dto';

@Injectable({
  providedIn: 'root'
})
export class SomDetailsService {
  private baseUrl = 'http://localhost:8080/api/som-details';

  constructor(private http: HttpClient) {}

  getSomDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/fetchSomDetails`);
  }

  validateFlag(): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/validateFlag`);
  }

  updateProposalStatus(): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/updateProposalStatus`, {});
  }

  getHubInchargeDetails(branchCode: string, applicationNo: string): Observable<HubInchargeDetailsDTO> {
    return this.http.get<HubInchargeDetailsDTO>(`${this.baseUrl}/getHubInchargeDetails`, {
      params: { branchCode, applicationNo }
    });
  }
}
