import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ViewImageService {
  private apiUrl = 'http://localhost:8080/api'; // Adjust the base URL as needed

  constructor(private http: HttpClient) {}

  viewImage(policyNumber: string): Observable<string> {
    if (!policyNumber) {
      return of('Policy number is null');
    }
    return this.generateUrl('NB', 'POLICY_DOCS', policyNumber).pipe(
      map((url: string) => {
        if (url) {
          window.open(url, '_blank');
          return 'URL opened successfully';
        } else {
          return 'Error: URL is null';
        }
      }),
      catchError((error) => of(`Error generating URL: ${error}`))
    );
  }

  generateUrl(type: string, category: string, policyNumber: string): Observable<string> {
    const url = `${this.apiUrl}/generateUrl?type=${type}&category=${category}&policyNumber=${policyNumber}`;
    return this.http.get<{ url: string }>(url).pipe(
      map(response => response.url),
      catchError((error) => of(`Error generating URL: ${error}`))
    );
  }

  getImageRecords(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/imageRecords`).pipe(
      catchError((error) => of([]))
    );
  }

  getImageById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/imageRecords/${id}`).pipe(
      catchError((error) => of(null))
    );
  }

  fetchImageDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/imageDetails`).pipe(
      catchError((error) => of(null))
    );
  }

  transferImage(proposalNumber: string, imageName: string): Observable<any> {
    const url = `${this.apiUrl}/transferImage?proposalNumber=${proposalNumber}&imageName=${imageName}`;
    return this.http.get<any>(url).pipe(
      catchError((error) => of(`Error transferring image: ${error}`))
    );
  }
}
