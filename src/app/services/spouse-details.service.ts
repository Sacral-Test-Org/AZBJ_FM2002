import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProofTypeDTO } from '../models/proof-type-dto.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SpouseDetailsService {
  private apiUrl = `${environment.apiUrl}/spouse-details`;

  constructor(private http: HttpClient) {}

  validateSpouseDOB(dob: Date): Observable<{ isValid: boolean, message: string }> {
    return this.http.post<{ isValid: boolean, message: string }>(`${this.apiUrl}/validate-dob`, { dob });
  }

  getProofTypes(): Observable<ProofTypeDTO[]> {
    return this.http.get<ProofTypeDTO[]>(`${this.apiUrl}/proof-types`);
  }

  saveProofType(proofType: ProofTypeDTO): Observable<any> {
    return this.http.post(`${this.apiUrl}/proof-types`, proofType);
  }

  calculateNetProfit(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/calculate-net-profit`);
  }
}
