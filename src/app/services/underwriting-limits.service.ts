import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class UnderwritingLimitsService {
  private apiUrl = 'http://your-backend-api-url/underwriting-limits';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getUnderwritingLimits(): Observable<any> {
    return this.http.get<any>(this.apiUrl).pipe(
      catchError(this.handleError.bind(this))
    );
  }

  private handleError(error: HttpErrorResponse) {
    this.logger.error('An error occurred:', error);
    let errorMessage = 'An unknown error occurred!';
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred.
      errorMessage = `An error occurred: ${error.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      errorMessage = `Server returned code: ${error.status}, error message is: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
