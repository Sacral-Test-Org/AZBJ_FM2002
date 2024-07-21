import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FurtherReqService {
  private baseUrl = '/api/further-req';

  constructor(private http: HttpClient) {}

  processRequest(requestType: string, testNumber: string, description: string, dateCalled: string): Observable<any> {
    const payload = { requestType, testNumber, description, dateCalled };
    return this.http.post(`${this.baseUrl}/processRequest`, payload);
  }

  fetchTooltipContent(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/tooltipContent`);
  }

  saveFormData(formData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/saveFormData`, formData);
  }

  checkFieldStatus(fieldName: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/checkFieldStatus`, { params: { fieldName } });
  }

  isSecndFrarReqEnabled(): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/isSecndFrarReqEnabled`);
  }

  navigateToSecndFrarReq(): void {
    // Logic to navigate to 'FURTHER_REQ.SECND_FRAR_REQ'
  }

  navigateToRcu(): void {
    // Logic to navigate to 'FURTHER_REQ.RCU'
  }

  addRequirement(requirement: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/addRequirement`, requirement);
  }

  deleteRequirement(requirementId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteRequirement/${requirementId}`);
  }

  updateRequirement(requirementId: number, updatedDetails: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateRequirement/${requirementId}`, updatedDetails);
  }

  validateRequirementNumber(requirementNumber: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/validateRequirementNumber`, { params: { requirementNumber } });
  }

  fetchFrequentRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/fetchFrequentRequirements`);
  }

  validateRequestNumber(requestNumber: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/validateRequestNumber`, { params: { requestNumber } });
  }

  fetchCurrentDate(): Observable<Date> {
    return this.http.get<Date>(`${this.baseUrl}/fetchCurrentDate`);
  }

  fetchExternalDate(): Observable<Date> {
    return this.http.get<Date>(`${this.baseUrl}/fetchExternalDate`);
  }

  fetchReqNoData(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/fetchReqNoData`);
  }

  checkAndPopulateFrarDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/checkAndPopulateFrarDetails`);
  }

  fetchLOVData(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/fetchLOVData`);
  }

  getTop20FrequentRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getTop20FrequentRequirements`);
  }

  fetchRcuRequirements(applicationNo: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/fetchRcuRequirements`, { params: { applicationNo } });
  }

  getCurrentDate(): Observable<Date> {
    return this.http.get<Date>(`${this.baseUrl}/getCurrentDate`);
  }

  getSpecificDate(): Observable<Date> {
    return this.http.get<Date>(`${this.baseUrl}/getSpecificDate`);
  }

  checkGlobalCondition(): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/checkGlobalCondition`);
  }

  setLOV(flag: boolean): void {
    // Logic to set the list of values (LOV) for the 'Further Requirements' field based on the flag
  }

  resetFields(): void {
    // Logic to reset certain fields related to the 'Further Requirements' field
  }

  getLOVValues(phonePeFlag: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getLOVValues`, { params: { phonePeFlag } });
  }

  validateAndDeleteRequirement(requirementId: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/validateAndDeleteRequirement`, { requirementId });
  }

  validateReceiptStatus(receiptStatus: string, testNumber: string, agentCode: string, statusFlag: string): Observable<any> {
    const payload = { receiptStatus, testNumber, agentCode, statusFlag };
    return this.http.post(`${this.baseUrl}/validateReceiptStatus`, payload);
  }

  processDeclaration(): Observable<any> {
    return this.http.post(`${this.baseUrl}/processDeclaration`, {});
  }

  addTestRequirement(testRequirement: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/addTestRequirement`, testRequirement);
  }

  deleteTestRequirement(testId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteTestRequirement/${testId}`);
  }

  getTestRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getTestRequirements`);
  }

  validateTestNumber(testNumber: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.baseUrl}/validateTestNumber`, { params: { testNumber } });
  }

  markAsReceived(testId: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/markAsReceived/${testId}`, {});
  }

  updateRequirementStatus(status: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateRequirementStatus`, { status });
  }

  fetchLOVData(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/fetchLOVData`);
  }

  getFurtherRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getFurtherRequirements`);
  }

  saveFurtherRequirements(furtherReqRequest: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/saveFurtherRequirements`, furtherReqRequest);
  }

  fetchFurtherRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/fetchFurtherRequirements`);
  }

  deleteRequirement(testNo: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteRequirement/${testNo}`);
  }

  synchronizeRecords(): Observable<any> {
    return this.http.post(`${this.baseUrl}/synchronizeRecords`, {});
  }

  getFurtherRequirements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getFurtherRequirements`);
  }

  navigateToDeclineRequest(): void {
    // Logic to navigate to the Decline Request section
  }

  fetchLOVData(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/fetchLOVData`);
  }
}
