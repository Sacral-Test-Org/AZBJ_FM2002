import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FakeDocument } from '../models/fake-document.model';

@Injectable({
  providedIn: 'root'
})
export class PrevFakeDocService {
  private apiUrl = 'http://localhost:8080/api/fake-documents';

  constructor(private http: HttpClient) { }

  getFakeDocuments(): Observable<FakeDocument[]> {
    return this.http.get<FakeDocument[]>(this.apiUrl);
  }
}