import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SeniorUnderwriterDTO } from '../models/senior-underwriter-dto.model';
import { SaveReasonDTO } from '../models/save-reason-dto.model';

@Injectable({
  providedIn: 'root'
})
export class SaveService {
  private readonly apiUrl = 'http://localhost:8080/api/save';

  constructor(private http: HttpClient) {}

  getSelectedAction(): string {
    return localStorage.getItem('selectedAction') || 'RW';
  }

  setSelectedAction(action: string): void {
    localStorage.setItem('selectedAction', action);
  }

  fetchSeniorUnderwriters(): Observable<SeniorUnderwriterDTO[]> {
    return this.http.get<SeniorUnderwriterDTO[]>(`${this.apiUrl}/senior-underwriters`);
  }

  cancelOperation(): void {
    // Handle any service calls related to the "Cancel" operation if needed.
  }

  updateStatus(action: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update-status`, { action });
  }

  saveReason(reason: string): Observable<any> {
    const saveReasonDTO: SaveReasonDTO = { reason };
    return this.http.post<any>(`${this.apiUrl}/save-reason`, saveReasonDTO);
  }
}
