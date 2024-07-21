import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoverheadService {
  constructor(private http: HttpClient) {}

  fetchLists(): Observable<any[]> {
    return this.http.get<any[]>('/api/predefined-lists');
  }

  saveAttributes(attributes: any): Observable<void> {
    return this.http.post<void>('/api/save-attributes', attributes);
  }

  updateSpwFlag(spwFlag: string): Observable<any> {
    return this.http.post<any>('/api/update-spw-flag', { spwFlag });
  }

  fetchReasonsForCounterOffers(): Observable<any[]> {
    return this.http.get<any[]>('/api/reasons-for-counter-offers');
  }

  fetchPackageDetails(productId: string, receiptDate: Date): Observable<any> {
    return this.http.get<any>(`/api/package-details?productId=${productId}&receiptDate=${receiptDate.toISOString()}`);
  }

  submitPolicyDetails(policyDetails: any): Observable<any> {
    return this.http.post<any>('/api/submit-policy-details', policyDetails);
  }

  calculateTerms(vestingAge: number, dateOfBirth: Date): Observable<any> {
    return this.http.post<any>('/api/calculate-terms', { vestingAge, dateOfBirth });
  }

  fetchData(): Observable<any> {
    return this.http.get<any>('/api/fetch-data');
  }

  clearData(): Observable<void> {
    return this.http.post<void>('/api/clear-data', {});
  }

  calculateSumAssured(premiumAmount: number, bookingFrequency: string): Observable<number> {
    return this.http.post<number>('/api/calculate-sum-assured', { premiumAmount, bookingFrequency });
  }

  getOpusDate(): Observable<string> {
    return this.http.get<string>('/api/opus-date');
  }

  determineAgeProofType(ageProofDetails: any): Observable<string> {
    return this.http.post<string>('/api/determine-age-proof-type', ageProofDetails);
  }

  getPaymentMethods(bookingFrequency: string, agentCode: string): Observable<string[]> {
    return this.http.get<string[]>(`/api/payment-methods?bookingFrequency=${bookingFrequency}&agentCode=${agentCode}`);
  }

  validateBookingFrequencyAndProductId(bookingFrequency: string, productId: string, receiptDate: Date, opusDate: Date): Observable<string> {
    return this.http.post<string>('/api/validate-booking-frequency-product-id', { bookingFrequency, productId, receiptDate, opusDate });
  }

  updateDiscountStatus(discountStatus: string): Observable<any> {
    return this.http.post<any>('/api/update-discount-status', { discountStatus });
  }

  getNextItem(productId: string): Observable<any> {
    return this.http.get<any>(`/api/next-item?productId=${productId}`);
  }

  copyCoverDetails(): Observable<any> {
    return this.http.get<any>('/api/load-cover-details');
  }

  validateInceptionDate(inceptionDate: Date): Observable<any> {
    return this.http.post<any>('/api/validate-inception-date', { inceptionDate });
  }

  getProductDetails(productId: number): Observable<any> {
    return this.http.get<any>(`/api/product-details?productId=${productId}`);
  }

  getPackageDetails(packageCode: string): Observable<any> {
    return this.http.get<any>(`/api/package-details?packageCode=${packageCode}`);
  }

  validatePackageCode(packageCode: string): Observable<any> {
    return this.http.get<any>(`/api/validate-package-code?packageCode=${packageCode}`);
  }

  updateBenefitType(packageCode: string): Observable<any> {
    return this.http.post<any>('/api/update-benefit-type', { packageCode });
  }

  updateXchgAdjField(value: string): void {
    // Logic to update the 'XCHG_ADJ' field with the provided value.
  }

  validateTerms(productID: number, packageCode: string, premiumTerm: number, benefitTerm: number): Observable<any> {
    return this.http.post<any>('/api/validate-terms', { productID, packageCode, premiumTerm, benefitTerm });
  }

  getPremiumTerms(): Observable<any> {
    return this.http.get<any>('/api/premium-terms');
  }

  checkServiceTaxApplicability(email: string): boolean {
    // Logic to check if the service tax is applicable for the given email ID.
    return true; // Placeholder return value
  }

  validateApplicationData(): Observable<any> {
    return this.http.get<any>('/api/validate-application-data');
  }

  initiateCounterOffer(): Observable<any> {
    return this.http.get<any>('/api/initiate-counter-offer');
  }

  validateMultiplier(multiplier: number, productId: number, package: string, bookingFrequency: string, premiumAmount: number): Observable<any> {
    return this.http.post<any>('/api/validate-multiplier', { multiplier, productId, package, bookingFrequency, premiumAmount });
  }

  getCurrentUsername(): Observable<string> {
    return this.http.get<string>('/api/current-username');
  }

  updateFields(fields: any): void {
    // Logic to update the necessary fields based on the input values.
  }

  getPremiumTerm(productId: number, coverCode: string, loanTerm: number): Observable<number> {
    return this.http.get<number>(`/api/premium-term?productId=${productId}&coverCode=${coverCode}&loanTerm=${loanTerm}`);
  }

  getBenefitTerm(productId: number, age: number): Observable<number> {
    return this.http.get<number>(`/api/benefit-term?productId=${productId}&age=${age}`);
  }

  fetchReasons(): Observable<string[]> {
    return this.http.get<string[]>('/api/reasons');
  }

  navigateToBalicRiskSection(): void {
    // Logic to navigate to the BALIC_RISK section and update risk data.
  }

  navigateToBalicRiskPhSection(): void {
    // Logic to navigate to the BALIC_RISK_PH section and update risk data.
  }

  validateLoanType(request: any): Observable<any> {
    return this.http.post<any>('/api/validate-loan-type', request);
  }

  navigateToNextItem(request: any): Observable<any> {
    return this.http.post<any>('/api/navigate-next-item', request);
  }

  calculateSumAssured(request: any): Observable<any> {
    return this.http.post<any>('/api/calculate-sum-assured', request);
  }

  updateCashBackFlag(request: any): Observable<any> {
    return this.http.post<any>('/api/update-cash-back-flag', request);
  }

  calculateSumAssuredOnDeath(request: any): Observable<any> {
    return this.http.post<any>('/api/calculate-sum-assured-on-death', request);
  }

  getControlFlag(): Observable<string> {
    return this.http.get<string>('/api/control-flag');
  }

  getPanApprovalDetails(): Observable<any> {
    return this.http.get<any>('/api/pan-approval-details');
  }

  updatePayoutFrequency(frequency: string): void {
    // Logic to update the payout frequency in the backend or local storage.
  }

  fetchPayoutFrequencies(): Observable<string[]> {
    return this.http.get<string[]>('/api/payout-frequencies');
  }

  updateTerms(premiumTerm: string, packageCode: string): Observable<any> {
    return this.http.post<any>('/api/update-terms', { premiumTerm, packageCode });
  }

  updateRelatedCovers(benefitTerm: string, packageCode: string): Observable<any> {
    return this.http.put<any>('/api/update-related-covers', { benefitTerm, packageCode });
  }

  processCoverRecords(): void {
    // Logic to process records in the 'covers' section.
  }

  calculateEntryAge(ip_date_of_birth: Date, ch_inception_date: Date, cn_effective_date: Date, type: string, value: number): number {
    // Logic to calculate the entry age based on the provided dates and parameters.
    return 0; // Placeholder return value
  }

  populateSolution(): Observable<any> {
    return this.http.post<any>('/api/populate-solution', {});
  }

  updateCoverheadVariables(): void {
    // Logic to update the coverhead variables as specified in the user story.
  }

  modifyInsuranceOffer(request: any): Observable<any> {
    return this.http.post<any>('/api/modify-insurance-offer', request);
  }

  calculatePremium(request: any): Observable<any> {
    return this.http.post<any>('/api/calculate-premium', request);
  }

  validateAgeProof(request: any): Observable<any> {
    return this.http.post<any>('/api/validate-age-proof', request);
  }

  validateBenefitTerm(benefitTerm: number): string {
    if (benefitTerm <= 0) {
      return 'Benefit Term cannot be less than or equal to zero.';
    }
    return '';
  }
}
