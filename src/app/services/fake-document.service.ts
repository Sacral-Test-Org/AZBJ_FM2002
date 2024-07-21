import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FakeDocumentDTO, Category, LovData, ProofType } from '../models/fake-document.model';

@Injectable({
  providedIn: 'root'
})
export class FakeDocumentService {
  private baseUrl = 'http://localhost:8080/api/fake-documents';

  constructor(private http: HttpClient) {}

  manageFakeDocument(fakeDocument: FakeDocumentDTO): Observable<any> {
    if (fakeDocument.id) {
      return this.http.put(`${this.baseUrl}/${fakeDocument.id}`, fakeDocument);
    } else {
      return this.http.post(this.baseUrl, fakeDocument);
    }
  }

  isDocumentFake(documentId: number): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/is-fake/${documentId}`);
  }

  fetchCommentsList(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/comments-list`);
  }

  fetchFakeDocumentValue(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/fake-document-value`);
  }

  fetchCategoryValues(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.baseUrl}/category-values`);
  }

  getLovData(documentCode: string, fakeDocumentValue: string): Observable<LovData[]> {
    return this.http.get<LovData[]>(`${this.baseUrl}/lov-data`, {
      params: { documentCode, fakeDocumentValue }
    });
  }

  saveFakeDocument(fakeDocument: FakeDocumentDTO): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/save`, fakeDocument);
  }

  getProofTypes(documentType: string): Observable<ProofType[]> {
    return this.http.get<ProofType[]>(`${this.baseUrl}/proof-types`, {
      params: { documentType }
    });
  }
}
