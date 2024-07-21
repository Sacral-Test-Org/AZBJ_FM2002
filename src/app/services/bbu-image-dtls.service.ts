import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class BbuImageDtlsService {
  private apiUrl = 'http://localhost:8080/api/bbu-image-dtls';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  validateAnswer(answer: string): Observable<void> {
    if (answer !== 'Y' && answer !== 'N') {
      this.logger.error('Invalid answer. Please enter Y for Yes or N for No.');
      return throwError('Invalid answer. Please enter Y for Yes or N for No.');
    }

    return this.http.post<void>(`${this.apiUrl}/validate-answer`, { answer })
      .pipe(
        catchError(error => {
          this.logger.error('Error validating answer', error);
          return throwError(error);
        })
      );
  }
}
