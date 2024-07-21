import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PartnerDetails } from '../models/partner-details.model';

@Injectable({
  providedIn: 'root'
})
export class PartnerDetailsService {
  private apiUrl = 'http://localhost:8080/api/partner-details';

  constructor(private http: HttpClient) { }

  getPartnerDetails(): Observable<PartnerDetails> {
    return this.http.get<PartnerDetails>(this.apiUrl);
  }
}