import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeclineService {
  private baseUrl = 'http://localhost:8080/api/decline';

  constructor(private http: HttpClient) { }

  getDropdownOptions(fieldType: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/dropdown-options/${fieldType}`);
  }

  saveDeclineDetails(declineDetails: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/save`, declineDetails);
  }

  fetchDistrictNames(state: string): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/districts`, { params: { state } });
  }

  fetchDeclineReasons(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/decline-reasons`);
  }
}
