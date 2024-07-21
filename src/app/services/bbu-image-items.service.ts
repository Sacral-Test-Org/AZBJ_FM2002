import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItemValues, BBUImageItem } from '../models/item-values.model';

@Injectable({
  providedIn: 'root'
})
export class BbuImageItemsService {
  private apiUrl = 'http://localhost:8080/api/bbu-image-items';

  constructor(private http: HttpClient) {}

  getItemValues(): Observable<ItemValues[]> {
    return this.http.get<ItemValues[]>(`${this.apiUrl}/values`);
  }

  saveItemValues(itemValue: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/save`, { itemValue });
  }

  getBBUImageItems(): Observable<BBUImageItem[]> {
    return this.http.get<BBUImageItem[]>(`${this.apiUrl}/all`);
  }

  populateGroupQuestion(groupQuestionNumber: number, serialNumber: number, dependentQuestion: string): void {
    // Logic to populate the group question based on the provided parameters
    // This would typically involve making an API call to the backend
    this.http.post(`${this.apiUrl}/populate-group-question`, {
      groupQuestionNumber,
      serialNumber,
      dependentQuestion
    }).subscribe();
  }

  deleteGroupQuestion(groupQuestionNumber: number, serialNumber: number, dependentQuestion: string): void {
    // Logic to delete the group question based on the provided parameters
    // This would typically involve making an API call to the backend
    this.http.post(`${this.apiUrl}/delete-group-question`, {
      groupQuestionNumber,
      serialNumber,
      dependentQuestion
    }).subscribe();
  }
}
