import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DoctorDetails, DoctorPanelData, ImageData, DoctorCodeValidationResponse, Doctor } from '../models/doctor.model';

@Injectable({
  providedIn: 'root'
})
export class PanelDoctorService {
  private baseUrl = 'http://localhost:8080/api/panel-doctor';

  constructor(private http: HttpClient) {}

  validateDoctorCode(doctorCode: string): Observable<DoctorDetails> {
    return this.http.get<DoctorDetails>(`${this.baseUrl}/validate/${doctorCode}`);
  }

  deleteDoctor(doctorCode: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${doctorCode}`);
  }

  populateDoctorPanel(): Observable<DoctorPanelData> {
    return this.http.get<DoctorPanelData>(`${this.baseUrl}/populate`);
  }

  viewImages(doctorCode: string): Observable<ImageData[]> {
    return this.http.get<ImageData[]>(`${this.baseUrl}/images/${doctorCode}`);
  }

  getOpusDate(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/opus-date`);
  }

  validateDoctorCode(lifeType: string, testCode: string, applicationNo: string): Observable<DoctorCodeValidationResponse> {
    return this.http.get<DoctorCodeValidationResponse>(`${this.baseUrl}/validate-code`, {
      params: { lifeType, testCode, applicationNo }
    });
  }

  fetchDoctorNames(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.baseUrl}/doctor-names`);
  }

  fetchDoctorDetails(policyRef: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/doctor-details/${policyRef}`);
  }
}
