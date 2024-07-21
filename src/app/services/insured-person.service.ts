import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InsuredPersonService {
  private apiUrl = `${environment.apiUrl}/insured-person`;

  constructor(private http: HttpClient) {}

  getInsuredPersonDetails(insuredPersonID: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${insuredPersonID}`);
  }

  saveInsuredPersonDetails(insuredPersonDetails: any): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}`, insuredPersonDetails);
  }

  updateFormStatus(): void {
    // Logic to update form status to 'Y' if the form is not in loading mode
  }

  validateAgeProof(ageProof: string): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/validate-age-proof/${ageProof}`);
  }

  getAgeProofUID(ageProof: string): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/age-proof-uid/${ageProof}`);
  }

  validateAgeProofID(ageProofType: string, ageProofID: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-age-proof-id`, { ageProofType, ageProofID });
  }

  validateMibCode(mibCode: string): boolean {
    if (mibCode.length >= 4 && !'GHJKMTWQS'.includes(mibCode[3].toUpperCase())) {
      return false;
    }
    if (mibCode.length >= 5 && !'XRZYE'.includes(mibCode[4].toUpperCase())) {
      return false;
    }
    if (mibCode.length >= 6 && !'NBCD'.includes(mibCode[5].toUpperCase())) {
      return false;
    }
    return true;
  }

  validateAnnualIncome(annualIncome: number): Observable<boolean> {
    return this.http.post<boolean>(`${this.apiUrl}/validate-annual-income`, { annualIncome });
  }

  saveAnnualIncome(annualIncome: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/save-annual-income`, { annualIncome });
  }

  getProbableCPDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/probable-cp-details`);
  }

  fetchInsuredPersonDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/details`);
  }

  validateWeight(weight: number, productDefinition: string, packageCode: string): boolean {
    if (weight <= 0) {
      return false;
    }
    // Additional validation logic based on productDefinition and packageCode
    return true;
  }

  getData(verificationNumber: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/load-data/${verificationNumber}`);
  }

  generateNewProposalNumber(): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/generate-new-proposal-number`);
  }

  fetchValidAgeProofTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/valid-age-proof-types`);
  }

  updateLateralShiftStatus(insuredPersonId: string, status: boolean): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/update-lateral-shift-status`, { insuredPersonId, status });
  }

  searchCustomerPartner(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/search-customer-partner`);
  }

  validateHeight(height: number): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-height`, { height });
  }

  generateProposalNumber(date: string): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/generate-proposal-number`, { date });
  }

  searchMailingAddress(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/search-mailing-address`);
  }

  fetchSurrogateIncomeProofList(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/surrogate-income-proof-list`);
  }

  fetchPassportDetails(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/passport-details`);
  }

  validateIpType(productId: number): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-ip-type`, { productId });
  }

  getQuestionnaireData(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/questionnaire-data`);
  }

  validate(questionnaireData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-questionnaire`, questionnaireData);
  }

  validatePolicy(policyValidationRequest: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/validate-policy`, policyValidationRequest);
  }

  navigateToInsuredPerson(): void {
    // Logic to navigate to the insured person section
  }

  generateOmniImagesUrl(): string {
    // Logic to generate the OMNI Images URL
    return '';
  }

  getEncryptedUrl(verificationNumber: string): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/generate-encrypted-url`, { verificationNumber });
  }
}
