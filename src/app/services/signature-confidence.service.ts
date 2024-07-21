import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

interface SignatureConfidence {
  documentName: string;
  confidencePercentage: number;
}

@Injectable({
  providedIn: 'root'
})
export class SignatureConfidenceService {
  private apiUrl = `${environment.apiUrl}/signature-confidence`;

  constructor(private http: HttpClient) {}

  getSignatureConfidenceDetails(applicationNumber: string): Observable<SignatureConfidence[]> {
    return this.http.get<SignatureConfidence[]>(`${this.apiUrl}/details`, {
      params: { applicationNumber }
    });
  }

  generateSecureUrl(params: { type: string; category: string; id: string }): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/generate-url`, {
      params
    });
  }
}
