import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LifeStyleService {
  private apiUrl = 'http://localhost:8080/api/lifestyle';

  constructor(private httpClient: HttpClient) {}

  getQuestions(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/questions`);
  }

  saveQuestion(question: any): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/questions`, question);
  }

  updateStatus(productId: number, primaryStatus: string, secondaryStatus: string): Observable<any> {
    const body = { productId, primaryStatus, secondaryStatus };
    return this.httpClient.post(`${this.apiUrl}/updateStatus`, body);
  }
}
