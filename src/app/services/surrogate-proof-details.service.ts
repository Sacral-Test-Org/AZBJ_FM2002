import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SurrogateProofDetailsDTO } from '../models/surrogate-proof-details.dto';

@Injectable({
  providedIn: 'root'
})
export class SurrogateProofDetailsService {
  private apiUrl = 'http://localhost:8080/api/surrogate-proof-details';

  constructor(private http: HttpClient) {}

  saveSurrogateProofDetails(details: SurrogateProofDetailsDTO): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/save`, details);
  }

  getProofTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/proof-types`);
  }
}
