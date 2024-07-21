import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProposalType, PolicyHolder, MailingAddressDTO, BankAccountDetails, VerificationStatus, PassportDetailsDTO, EiaDetailsDTO, LanguageDTO, PolicyHolderSearchRequest, PolicyHolderSearchResponse } from '../models';

@Injectable({
  providedIn: 'root'
})
export class PolicyHolderService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getDropdownData(): Observable<any> {
    return this.http.get(`${this.baseUrl}/dropdown-data`);
  }

  savePolicyHolder(policyHolder: PolicyHolder): Observable<any> {
    return this.http.post(`${this.baseUrl}/policy-holder`, policyHolder);
  }

  validateGlobalLoadingFlag(): boolean {
    // Logic to return the value of the global loading flag
    return true; // Placeholder logic
  }

  fetchProposalTypes(): Observable<ProposalType[]> {
    return this.http.get<ProposalType[]>(`${this.baseUrl}/proposal-types`);
  }

  validateAgeProof(ageProof: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/validate-age-proof`, { ageProof });
  }

  updateFormStatus(formStatus: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/update-form-status`, { formStatus });
  }

  updatePolicyHolderDetails(policyHolder: PolicyHolder): Observable<any> {
    return this.http.put(`${this.baseUrl}/policy-holder`, policyHolder);
  }

  clearPolicyHolderDetails(): Observable<any> {
    return this.http.delete(`${this.baseUrl}/policy-holder`);
  }

  getValidPaCodes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/valid-pa-codes`);
  }

  validatePaCode(paCode: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/validate-pa-code`, { paCode });
  }

  updateTelephone2(telephone2: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-telephone2`, { telephone2 });
  }

  validatePanIssuanceDate(panIssuanceDate: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/validate-pan-issuance-date`, { panIssuanceDate });
  }

  searchMailingAddress(partnerId: string): Observable<MailingAddressDTO> {
    return this.http.get<MailingAddressDTO>(`${this.baseUrl}/mailing-address/${partnerId}`);
  }

  savePanIssuanceDateState(isAvailable: boolean): void {
    // Logic to save the state of PAN issuance date availability
  }

  getBankAccountDetails(applicationNumber: string): Observable<BankAccountDetails> {
    return this.http.get<BankAccountDetails>(`${this.baseUrl}/bank-account-details/${applicationNumber}`);
  }

  getVerificationStatus(applicationNumber: string): Observable<VerificationStatus> {
    return this.http.get<VerificationStatus>(`${this.baseUrl}/verification-status/${applicationNumber}`);
  }

  validateAgeProofDetails(ageProofType: string, ageProofID: string, agentCode: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/validate-age-proof-details`, { ageProofType, ageProofID, agentCode });
  }

  fetchPassportDetails(): Observable<PassportDetailsDTO> {
    return this.http.get<PassportDetailsDTO>(`${this.baseUrl}/passport-details`);
  }

  verifyVoterId(): Observable<any> {
    return this.http.get(`${this.baseUrl}/verify-voter-id`);
  }

  getDrivingLicenseDetails(): Observable<DrivingLicenseDetailsDTO> {
    return this.http.get<DrivingLicenseDetailsDTO>(`${this.baseUrl}/driving-license-details`);
  }

  createParameterList(): object {
    // Logic to create a new parameter list and add necessary parameters
    return {};
  }

  callFinancialDocumentForm(parameterList: object): void {
    this.http.post(`${this.baseUrl}/call-financial-document-form`, parameterList).subscribe();
  }

  getEiaDetails(applicationNumber: string): Observable<EiaDetailsDTO> {
    return this.http.get<EiaDetailsDTO>(`${this.baseUrl}/eia-details/${applicationNumber}`);
  }

  openEIAccount(): Observable<any> {
    return this.http.post(`${this.baseUrl}/open-ei-account`, {});
  }

  searchPolicyHolder(policyHolderSearchRequest: PolicyHolderSearchRequest): Observable<PolicyHolderSearchResponse> {
    return this.http.post<PolicyHolderSearchResponse>(`${this.baseUrl}/search-policy-holder`, policyHolderSearchRequest);
  }

  fetchLanguages(): Observable<LanguageDTO[]> {
    return this.http.get<LanguageDTO[]>(`${this.baseUrl}/languages`);
  }

  updateCommunicationLanguage(languageId: number): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/update-communication-language`, { languageId });
  }

  saveDropdownValue(value: string): void {
    // Logic to save the selected value of the dropdown list
  }

  getDropdownOptions(): string[] {
    // Logic to return the predefined options for the dropdown list
    return [];
  }

  getRelationshipType(): string {
    // Logic to return the relationship type as a string
    return '';
  }
}
