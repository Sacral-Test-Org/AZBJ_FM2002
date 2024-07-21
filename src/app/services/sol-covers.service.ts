import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SolCoversService {
  private apiUrl = 'http://localhost:8080/api/sol_covers';

  constructor(private http: HttpClient) {}

  getAllRecords(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

  updateRecord(record: any): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, record);
  }

  updateCovers(benefitTerm: number, premiumTerm: number): Observable<any> {
    const body = { benefitTerm, premiumTerm };
    return this.http.put<any>(`${this.apiUrl}/updateCovers`, body);
  }

  getCoverCode(): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/coverCode`);
  }

  deleteRecord(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}