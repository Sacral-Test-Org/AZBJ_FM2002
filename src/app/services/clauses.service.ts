import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clause } from '../models/clause.model';

@Injectable({
  providedIn: 'root'
})
export class ClausesService {
  private apiUrl = 'http://localhost:8080/api/clauses';

  constructor(private http: HttpClient) { }

  getClauses(): Observable<Clause[]> {
    return this.http.get<Clause[]>(this.apiUrl);
  }

  deleteClause(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}