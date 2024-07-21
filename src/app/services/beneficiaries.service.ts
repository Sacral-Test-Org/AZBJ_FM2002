import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NomineeDetails, BeneficialOwner, ValidationResponse } from '../models/beneficiaries.model';

@Injectable({
  providedIn: 'root'
})
export class BeneficiariesService {
  private baseUrl = 'http://localhost:8080/api/beneficiaries';

  constructor(private http: HttpClient) {}

  deleteNominee(nomineeId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/nominee/${nomineeId}`);
  }

  getNomineeDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}/nominee-details`);
  }

  validateDOB(dateOfBirth: Date): boolean {
    const today = new Date();
    const age = today.getFullYear() - dateOfBirth.getFullYear();
    const monthDiff = today.getMonth() - dateOfBirth.getMonth();
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dateOfBirth.getDate())) {
      age--;
    }
    return age >= 18;
  }

  fetchNomineeDetails(applicationNo: string, proposalNo: string): Observable<NomineeDetails[]> {
    return this.http.get<NomineeDetails[]>(`${this.baseUrl}/nominee-details`, {
      params: { applicationNo, proposalNo }
    });
  }

  saveNomineeDetails(nomineeDetails: NomineeDetails[]): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/nominee-details`, nomineeDetails);
  }

  validateAppointeeFields(beneficiaryDOB: Date): void {
    const isAdult = this.validateDOB(beneficiaryDOB);
    if (isAdult) {
      // Clear appointee fields and disable them
      // Logic to clear and disable appointee fields
    } else {
      // Enable appointee fields
      // Logic to enable appointee fields
    }
  }

  validateBeneficialOwnerRecord(beneficialOwner: BeneficialOwner): Observable<ValidationResponse> {
    return this.http.post<ValidationResponse>(`${this.baseUrl}/beneficial-owner`, beneficialOwner);
  }
}