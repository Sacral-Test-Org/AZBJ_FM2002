import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CoversHealthDTO } from '../models/covers-health-dto.model';
import { EntryAgeValidationRequest, EntryAgeValidationResponse } from '../models/entry-age-validation.model';
import { TermsCalculationRequest, TermsCalculationResponse } from '../models/terms-calculation.model';

@Injectable({
  providedIn: 'root'
})
export class CoversHealthService {
  private globalBenefitTerm: string;

  constructor(private http: HttpClient) {}

  getCoverDetails(productId: number): Observable<CoversHealthDTO[]> {
    const url = `/api/covers-health/${productId}`;
    return this.http.get<CoversHealthDTO[]>(url);
  }

  saveCoverDetails(coversHealthDTO: CoversHealthDTO): Observable<CoversHealthDTO> {
    const url = '/api/covers-health';
    return this.http.post<CoversHealthDTO>(url, coversHealthDTO);
  }

  setGlobalBenefitTerm(benefitTerm: string): void {
    this.globalBenefitTerm = benefitTerm;
  }

  validateEntryAge(entryAge: number): Observable<EntryAgeValidationResponse> {
    const url = '/api/covers-health/validate-entry-age';
    const request: EntryAgeValidationRequest = { entryAge };
    return this.http.post<EntryAgeValidationResponse>(url, request);
  }

  calculateTerms(entryAge: number, packageMaturityDate: Date): Observable<TermsCalculationResponse> {
    const url = '/api/covers-health/calculate-terms';
    const request: TermsCalculationRequest = { entryAge, packageMaturityDate };
    return this.http.post<TermsCalculationResponse>(url, request);
  }
}
