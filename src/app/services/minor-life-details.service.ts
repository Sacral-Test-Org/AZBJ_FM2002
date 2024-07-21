import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MinorLifeDetailsService {

  private apiUrl = 'http://localhost:8080/api/minor-life-details';

  constructor(private http: HttpClient) { }

  // Method to save minor life details
  saveMinorLifeDetails(details: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, details);
  }

  // Method to get minor life details
  getMinorLifeDetails(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  // Method to update minor life details
  updateMinorLifeDetails(id: number, details: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, details);
  }

  // Method to delete minor life details
  deleteMinorLifeDetails(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
