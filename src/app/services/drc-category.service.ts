import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrcCategoryService {
  private apiUrl = 'http://your-api-url.com/api/drc-category';

  constructor(private http: HttpClient) {}

  saveDrcCategory(newValue: string): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}`, { value: newValue });
  }
}
