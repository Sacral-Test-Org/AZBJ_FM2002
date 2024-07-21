import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SolCoverheadService {
  private apiUrl = 'http://localhost:8080/api/sol-coverhead';

  constructor(private http: HttpClient) {}

  getSumAssured(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/sum-assured`);
  }

  getSolutionName(): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/solution-name`);
  }

  calculateTerms(productDefinition: string, pensionFlag: number, bookingFrequency: string, dateOfBirth: Date, vestingAge: number): Observable<{ benefitTerm: number, premiumTerm: number }> {
    const params = { productDefinition, pensionFlag, bookingFrequency, dateOfBirth, vestingAge };
    return this.http.post<{ benefitTerm: number, premiumTerm: number }>(`${this.apiUrl}/calculate-terms`, params);
  }

  updateMoneyBackOption(option: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update-money-back-option`, { option });
  }

  getDiscountOptions(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/discount-options`);
  }

  validateSolutionName(solutionName: string): boolean {
    return solutionName !== '';
  }

  calculateBeneficiaryAge(dateOfBirth: Date): number {
    const ageDifMs = Date.now() - dateOfBirth.getTime();
    const ageDate = new Date(ageDifMs);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  }

  processRecords(): void {
    // Logic to process records
  }

  getDiscountType(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/discount-type`);
  }

  deleteBeneficiaryTrusteeRep(contractId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/beneficiary-trustee-rep/${contractId}`);
  }
}
