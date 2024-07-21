import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Comment {
  question: string;
  comment: string;
  user: string;
  date: string;
}

@Injectable({
  providedIn: 'root'
})
export class CrmCommentsService {
  private apiUrl = 'http://localhost:8080/api/comments';

  constructor(private http: HttpClient) { }

  getComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.apiUrl);
  }
}