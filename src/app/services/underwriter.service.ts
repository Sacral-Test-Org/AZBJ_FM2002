import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface UnderwriterInfo {
  userId: string;
  name: string;
}

interface UnderwriterValidationResponse {
  valid: boolean;
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class UnderwriterService {
  private apiUrl = 'http://localhost:8080/api/underwriters';

  constructor(private http: HttpClient) {}

  getUnderwriterInfo(): Observable<UnderwriterInfo> {
    return this.http.get<UnderwriterInfo>(`${this.apiUrl}/info`);
  }

  forwardCaseToUnderwriter(caseDetails: string): Observable<any> {
    const payload = { caseDetails };
    return this.http.post(`${this.apiUrl}/forward`, payload);
  }

  validateUnderwriter(underwriterId: string): Observable<UnderwriterValidationResponse> {
    return this.http.get<UnderwriterValidationResponse>(`${this.apiUrl}/validate/${underwriterId}`);
  }
}
