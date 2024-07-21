import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidationResponse } from '../models/validation-response.model';
import { BusinessUnit } from '../models/business-unit.model';

@Injectable({
  providedIn: 'root'
})
export class AzbjBbuQuestionsService {
  private baseUrl = 'http://localhost:8080/api/azbj-bbu-questions';

  constructor(private http: HttpClient) {}

  validateAnswers(answers: any[]): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/validate-answers`, answers);
  }

  processAnswers(answers: any[]): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/process-answers`, answers);
  }

  validateAnswer(questionId: number, answer: string): Observable<ValidationResponse> {
    return this.http.post<ValidationResponse>(`${this.baseUrl}/validate-answer`, { questionId, answer });
  }

  getBusinessUnits(): Observable<BusinessUnit[]> {
    return this.http.get<BusinessUnit[]>(`${this.baseUrl}/business-units`);
  }

  updateBusinessUnit(businessUnit: BusinessUnit): Observable<BusinessUnit> {
    return this.http.put<BusinessUnit>(`${this.baseUrl}/business-units/${businessUnit.id}`, businessUnit);
  }
}