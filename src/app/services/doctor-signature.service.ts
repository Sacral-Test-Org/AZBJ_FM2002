import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class DoctorSignatureService {
  private apiUrl = 'http://localhost:8080/api/doctor-signature';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  verifyDoctorSignature(doctorCode: string): Observable<any> {
    const url = `${this.apiUrl}/verify`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = { doctorCode };

    this.logger.debug('Verifying doctor signature for code:', doctorCode);

    return this.http.post<any>(url, body, { headers }).pipe(
      catchError((error) => {
        this.logger.error('Error verifying doctor signature:', error);
        throw error;
      })
    );
  }
}
