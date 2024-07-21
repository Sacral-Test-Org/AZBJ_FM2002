import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ValidationError, ValidationItem } from '../models/validation-error.model';

@Injectable({
  providedIn: 'root'
})
export class ValidationErrorListService {
  private apiUrl = 'http://localhost:8080/api/validation-errors';

  constructor(private http: HttpClient) {}

  fetchValidationErrors(): Observable<ValidationError[]> {
    return this.http.get<ValidationError[]>(this.apiUrl);
  }

  fetchValidationItem(blockName: string, itemName: string): Observable<ValidationItem> {
    const url = `${this.apiUrl}/item?blockName=${blockName}&itemName=${itemName}`;
    return this.http.get<ValidationItem>(url);
  }
}
