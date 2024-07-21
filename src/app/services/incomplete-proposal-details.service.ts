import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IncompleteProposalDetailsService {
  private apiUrl = 'http://your-backend-api-url'; // Replace with your actual backend API URL

  constructor(private http: HttpClient) { }

  getDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/incomplete-proposal-details`).pipe(
      catchError(this.handleError)
    );
  }

  deleteRecord(recordId: string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/incomplete-proposal-details/${recordId}`).pipe(
      catchError(this.handleError)
    );
  }

  fetchExistingRecords(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/incomplete-proposal-details`).pipe(
      catchError(this.handleError)
    );
  }

  saveIncompleteProposalDetails(details: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/incomplete-proposal-details`, details).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
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
