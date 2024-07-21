import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewBusinessService {
  private baseUrl = 'http://localhost:8080/api/relationship-details';

  constructor(private http: HttpClient) { }

  addRelationshipDetail(relationshipDetail: string): Observable<any> {
    const payload = { detail: relationshipDetail };
    return this.http.post(`${this.baseUrl}/add`, payload);
  }

  updateRelationshipDetail(id: number, relationshipDetail: string): Observable<any> {
    const payload = { detail: relationshipDetail };
    return this.http.put(`${this.baseUrl}/update/${id}`, payload);
  }

  getRelationshipDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}/list`);
  }
}
