import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AmlDetailsDTO, ProofType, ProofDescription, AmlValidationRequest, AmlValidationResponse, ProofDetailsDTO, PanDetailsDTO } from '../models/aml.model';

@Injectable({
  providedIn: 'root'
})
export class AmlService {
  private baseUrl = 'http://localhost:8080/api/aml';

  constructor(private http: HttpClient) {}

  processAmlRecords(): void {
    // Logic to process records in the 'AML' section
    // Implement the logic based on the user story
  }

  fetchProofTypes(): Observable<ProofType[]> {
    return this.http.get<ProofType[]>(`${this.baseUrl}/proof-types`);
  }

  fetchProofDescriptions(): Observable<ProofDescription[]> {
    return this.http.get<ProofDescription[]>(`${this.baseUrl}/proof-descriptions`);
  }

  populateAmlDetails(): Observable<AmlDetailsDTO> {
    return this.http.post<AmlDetailsDTO>(`${this.baseUrl}/populate-aml-details`, {});
  }

  fetchDocumentType(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/document-type`);
  }

  fetchChkEditAml(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/chk-edit-aml`);
  }

  validateAmlDetails(request: AmlValidationRequest): Observable<AmlValidationResponse> {
    return this.http.post<AmlValidationResponse>(`${this.baseUrl}/validate-aml-details`, request);
  }

  fetchProofDetails(proofType: string, documentType: string, partnerType: string): Observable<ProofDetailsDTO> {
    return this.http.get<ProofDetailsDTO>(`${this.baseUrl}/proof-details`, {
      params: { proofType, documentType, partnerType }
    });
  }

  getChkEditAmlStatus(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/chk-edit-aml-status`);
  }

  validateDocumentId(documentId: string): Observable<ValidationResponse> {
    return this.http.post<ValidationResponse>(`${this.baseUrl}/validate-document-id`, { documentId });
  }

  getPanDetails(): Observable<PanDetailsDTO[]> {
    return this.http.get<PanDetailsDTO[]>(`${this.baseUrl}/pan-details`);
  }
}
