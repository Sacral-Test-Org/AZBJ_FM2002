import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TestNumberDTO } from '../models/test-number-dto.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class DeclineReqService {
  private apiUrl = 'http://localhost:8080/api/decline-req';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  fetchValidTestNumbers(): Observable<TestNumberDTO[]> {
    this.logger.debug('Fetching valid test numbers from the back-end');
    return this.http.get<TestNumberDTO[]>(`${this.apiUrl}/valid-test-numbers`);
  }
}
