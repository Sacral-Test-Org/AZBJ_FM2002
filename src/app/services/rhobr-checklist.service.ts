import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ChecklistItem } from '../models/checklist-item.model';

@Injectable({
  providedIn: 'root'
})
export class RhobrChecklistService {
  private apiUrl = 'http://localhost:8080/api/checklist';

  constructor(private http: HttpClient) {}

  getChecklist(): Observable<ChecklistItem[]> {
    return this.http.get<ChecklistItem[]>(`${this.apiUrl}`);
  }

  updateChecklist(item: ChecklistItem): Observable<ChecklistItem> {
    return this.http.put<ChecklistItem>(`${this.apiUrl}/${item.id}`, item);
  }

  changeStatusToRhobr(itemId: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${itemId}/changeStatusToRhobr`, {});
  }
}
