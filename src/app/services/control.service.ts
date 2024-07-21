import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class ControlService {
  private baseUrl = '/api/control';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  fetchQuestions(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/questions`).pipe(
      catchError(this.handleError)
    );
  }

  saveResponsesToDB(policyRef: string, contractId: string, questions: any[]): Observable<any> {
    return this.http.post(`${this.baseUrl}/saveResponses`, { policyRef, contractId, questions }).pipe(
      catchError(this.handleError)
    );
  }

  saveRelationWithStaff(relationWithStaff: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/saveRelationWithStaff`, { relationWithStaff }).pipe(
      catchError(this.handleError)
    );
  }

  getCRMComments(contractId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/crmComments/${contractId}`).pipe(
      catchError(this.handleError)
    );
  }

  updateCRMComments(crmComments: any[]): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/crmComments`, crmComments).pipe(
      catchError(this.handleError)
    );
  }

  navigateToInsuredPersonDetails(): void {
    // Implement navigation logic to navigate to the insured person's details screen.
    // Set the focus to the insured person's name field.
  }

  checkForDuplicateContacts(contactDetails: any): boolean {
    // Check if the provided contact details already exist in the system.
    // Return a boolean indicating whether a duplicate contact was found.
    return false; // Placeholder logic
  }

  invokeEnrichmentForm(applicationNo: string, callFormName: string, proposalNo: string, laName: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/invokeEnrichmentForm`, { applicationNo, callFormName, proposalNo, laName }).pipe(
      catchError(this.handleError)
    );
  }

  updateStatus(status: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/updateStatus`, { status }).pipe(
      catchError(this.handleError)
    );
  }

  getPartnerTypeData(partnerType: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/partnerTypeData/${partnerType}`).pipe(
      catchError(this.handleError)
    );
  }

  toggleValidation(): void {
    // This method will disable validation for the fields: identity document, identity proof, address ID, and address proof.
  }

  navigateToCFT(): void {
    // This method will navigate to the CFT block and display the first record.
  }

  setSuspectedScreenActive(): void {
    // Set a flag indicating that the suspected screen is active.
  }

  handleError(error: any): void {
    this.logger.error('An error occurred:', error);
    // Display an error message to the user.
  }

  checkUserAuthorization(): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/checkAuthorization`).pipe(
      catchError(this.handleError)
    );
  }

  updateHOAllocationValues(): void {
    this.http.post<void>(`${this.baseUrl}/updateHOAllocationValues`, {}).pipe(
      catchError(this.handleError)
    ).subscribe();
  }

  navigateToAMLBlock(): Observable<any> {
    // Use Angular Router to navigate to the AML block.
    // Fetch the first record in the AML block.
    // Return an Observable to allow the component to subscribe and handle the response.
    return new Observable(); // Placeholder logic
  }

  enableInsertUpdate(): void {
    // Enable the ability to insert and update records in the risk score details section.
  }

  navigateToControlSection(): void {
    // Navigate the user to the control section.
  }

  updatePolicyStatus(status: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/updatePolicyStatus`, { status }).pipe(
      catchError(this.handleError)
    );
  }

  getDoctorMobAppInfo(applicationNumber: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/doctorMobAppInfo/${applicationNumber}`).pipe(
      catchError(this.handleError)
    );
  }

  getRiskScoreDetails(applicationNo: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/riskScoreDetails/${applicationNo}`).pipe(
      catchError(this.handleError)
    );
  }

  validateCredentials(loginId: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/validateCredentials`, { loginId, password }).pipe(
      catchError(this.handleError)
    );
  }

  authenticateSupervisor(username: string, password: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.baseUrl}/authenticateSupervisor`, { username, password }).pipe(
      catchError(this.handleError)
    );
  }

  calculatePPC(): Observable<any> {
    return this.http.get(`${this.baseUrl}/calculatePPC`).pipe(
      catchError(this.handleError)
    );
  }

  getProofTypes(premiumPayer: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/proofTypes/${premiumPayer}`).pipe(
      catchError(this.handleError)
    );
  }

  getFinancialDetails(premiumPayer: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/financialDetails/${premiumPayer}`).pipe(
      catchError(this.handleError)
    );
  }

  getSpouseFinancialDetails(premiumPayer: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/spouseFinancialDetails/${premiumPayer}`).pipe(
      catchError(this.handleError)
    );
  }

  getLiquidInvestmentDetails(premiumPayer: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/liquidInvestmentDetails/${premiumPayer}`).pipe(
      catchError(this.handleError)
    );
  }

  getBeneficialOwnershipDetails(contractId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/beneficialOwnershipDetails/${contractId}`).pipe(
      catchError(this.handleError)
    );
  }

  getRefreshedDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/refreshedDetails`).pipe(
      catchError(this.handleError)
    );
  }

  createParameterList(params: { [key: string]: any }): Observable<any> {
    // Create a new parameter list with the given parameters.
    return new Observable(); // Placeholder logic
  }

  callForm(formName: string, params: { [key: string]: any }): Observable<any> {
    // Call the specified form with the given parameters.
    return new Observable(); // Placeholder logic
  }

  getAgentDetails(agentCode: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/agent-details/${agentCode}`).pipe(
      catchError(this.handleError)
    );
  }

  getCRIFList(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/crifList`).pipe(
      catchError(this.handleError)
    );
  }

  updateFormStatus(status: string): void {
    // Update the form status with the provided status value.
  }

  updateCrifScoreAndIncomeSegment(verificationNumber: string, signCardNumber: string, policyReference: string, userInfo: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/updateCrifScoreAndIncomeSegment`, { verificationNumber, signCardNumber, policyReference, userInfo }).pipe(
      catchError(this.handleError)
    );
  }

  checkAllPoliciesReviewed(): boolean {
    // Check if all policies have been reviewed.
    // Return true if all policies are reviewed, otherwise return false.
    return false; // Placeholder logic
  }

  checkUWDecision(): boolean {
    // Check if the "UW Decision" field is not empty.
    // Return true if the field is not empty, otherwise return false.
    return false; // Placeholder logic
  }

  checkUWComments(): boolean {
    // Check if the "UW Comments" field is not empty.
    // Return true if the field is not empty, otherwise return false.
    return false; // Placeholder logic
  }

  getPreviousPolicyDetails(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/previousPolicyDetails`).pipe(
      catchError(this.handleError)
    );
  }

  validateAndProcessPolicy(data: { underwritingReview: boolean, underwritingDecision: string, underwritingComments: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/validateAndProcessPolicy`, data).pipe(
      catchError(this.handleError)
    );
  }

  getVideoCallingStatus(applicationNumber: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/videoCallingStatus/${applicationNumber}`).pipe(
      catchError(this.handleError)
    );
  }
}
