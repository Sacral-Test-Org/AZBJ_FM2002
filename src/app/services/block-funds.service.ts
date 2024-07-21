import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fund } from '../models/fund.model';

@Injectable({
  providedIn: 'root'
})
export class BlockFundsService {
  private apiUrl = 'https://api.example.com/funds'; // Replace with actual API endpoint

  constructor(private http: HttpClient) { }

  getFunds(): Observable<Fund[]> {
    return this.http.get<Fund[]>(this.apiUrl);
  }
}