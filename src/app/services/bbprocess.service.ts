import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class BbprocessService {
  private baseUrl = 'http://localhost:8080/api/bbprocess';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  populateQuestions(partnerId: string): Observable<any> {
    if (!partnerId) {
      this.logger.error('Please select partner');
      throw new Error('Please select partner');
    }
    this.logger.info(`Populating questions for partner ID: ${partnerId}`);
    return this.http.get(`${this.baseUrl}/populate-questions`, { params: { partnerId } });
  }

  fetchQuestionsAndAnswers(partnerId: string): Observable<any> {
    if (!partnerId) {
      this.logger.error('Please select partner');
      throw new Error('Please select partner');
    }
    this.logger.info(`Fetching questions and answers for partner ID: ${partnerId}`);
    return this.http.get(`${this.baseUrl}/questions-answers`, { params: { partnerId } });
  }
}