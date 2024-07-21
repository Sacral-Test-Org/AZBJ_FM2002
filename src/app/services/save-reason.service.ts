import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaveReasonService {
  private saveReasonUrl = '/api/save-reason';
  private exitFormUrl = '/api/exit-form';

  constructor(private http: HttpClient) { }

  saveReason(reason: string): Observable<any> {
    return this.http.post(this.saveReasonUrl, { reason });
  }

  exitForm(): Observable<any> {
    return this.http.get(this.exitFormUrl);
  }
}
