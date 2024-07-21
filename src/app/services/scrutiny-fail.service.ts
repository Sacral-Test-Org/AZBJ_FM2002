import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScrutinyFailService {
  private apiUrl = 'http://localhost:8080/api/scrutiny-fail';

  constructor(private http: HttpClient) {}

  fetchDocumentDescription(): Observable<string[]> {
    // Logic to fetch document description data if needed
    return this.http.get<string[]>(`${this.apiUrl}/document-descriptions`);
  }

  updateCommentsField(description: string): void {
    // Logic to update the state of the Comments field based on the document description
    const commentsField = document.getElementById('comments') as HTMLInputElement;
    if (description === 'Others') {
      commentsField.readOnly = false;
    } else {
      commentsField.readOnly = true;
    }
  }

  saveDocumentReceiptStatus(status: string): void {
    // Logic to call the saveDocumentReceiptStatus method of the ScrutinyFailureController to save the document receipt status
    this.http.post(`${this.apiUrl}/document-receipt-status`, { status }).subscribe();
  }

  getDocumentReceiptStatus(): Observable<string> {
    // Logic to call the getDocumentReceiptStatus method of the ScrutinyFailureController to retrieve the current document receipt status
    return this.http.get<string>(`${this.apiUrl}/document-receipt-status`);
  }

  updateScrutinyFailDetails(scrutinyFailDetails: any): Observable<any> {
    // Logic to call the back-end API to update the scrutiny fail document details
    return this.http.put(`${this.apiUrl}/update`, scrutinyFailDetails);
  }

  saveScrutinyFailDocuments(scrutinyFailDocuments: any[]): Observable<any> {
    // Logic to call the saveScrutinyFailDocuments method from ScrutinyFailureController to save the scrutiny failure document details
    return this.http.post(`${this.apiUrl}/save`, scrutinyFailDocuments);
  }
}
