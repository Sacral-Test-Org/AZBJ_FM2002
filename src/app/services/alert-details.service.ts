import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AlertDetails } from '../models/alert-details.model';

@Injectable({
  providedIn: 'root'
})
export class AlertDetailsService {
  private apiUrl = 'http://your-api-url/alert-details';

  constructor(private http: HttpClient) { }

  getAlertDetails(): Observable<AlertDetails> {
    return this.http.get<AlertDetails>(this.apiUrl);
  }
}
