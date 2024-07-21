import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class ThirdPartyChequeService {
  private apiUrl = 'http://localhost:8080/api/third-party-cheque';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  saveThirdPartyChequeDetails(paymentMode: string, questions: string, confidencePercentage: number): Observable<any> {
    const body = {
      paymentMode: paymentMode,
      questions: questions,
      confidencePercentage: confidencePercentage
    };
    this.logger.debug('Saving third-party cheque details', body);
    return this.http.post<any>(`${this.apiUrl}/save`, body);
  }
}
