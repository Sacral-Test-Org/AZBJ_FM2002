import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VideoCallingService {
  private apiUrl = `${environment.apiUrl}/video-call`;

  constructor(private http: HttpClient) { }

  initiateVideoCall(): Observable<any> {
    return this.http.post(`${this.apiUrl}/initiate`, {});
  }
}
