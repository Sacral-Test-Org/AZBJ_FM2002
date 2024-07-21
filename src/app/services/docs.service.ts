import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RejectedApplicationReasonDTO } from '../models/rejected-application-reason-dto.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DocsService {
  private apiUrl = `${environment.apiUrl}/rejected-applications`;

  constructor(private http: HttpClient) { }

  getRejectedApplicationReasons(applicationNo: string, alternateReq: string): Observable<RejectedApplicationReasonDTO[]> {
    const url = `${this.apiUrl}?applicationNo=${applicationNo}&alternateReq=${alternateReq}`;
    return this.http.get<RejectedApplicationReasonDTO[]>(url);
  }
}