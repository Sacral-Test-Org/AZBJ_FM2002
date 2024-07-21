import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class FamilyHistService {
  private baseUrl = 'http://localhost:8080/api/family-hist';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  deleteMember(memberId: number): Observable<any> {
    this.logger.info(`Deleting member with ID: ${memberId}`);
    return this.http.delete(`${this.baseUrl}/delete/${memberId}`);
  }
}
