import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MedicalRecord } from '../models/medical-record.model';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class PreviousMedicalsService {
  private apiUrl = 'http://localhost:8080/api/medical-records';
  private encryptionKey = 'your-encryption-key'; // Replace with your actual encryption key

  constructor(private http: HttpClient) {}

  fetchPreviousMedicalRecords(): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(this.apiUrl);
  }

  generateEncryptedURL(policyReference: string): string {
    const url = `http://localhost:8080/api/medical-records/images?policyRef=${policyReference}`;
    const encryptedURL = CryptoJS.AES.encrypt(url, this.encryptionKey).toString();
    return encryptedURL;
  }
}