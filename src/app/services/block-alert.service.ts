import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BlockAlertValidationRequest } from 'src/main/java/com/azbj/fm2002/dto/BlockAlertValidationRequest';
import { BlockAlertValidationResponse } from 'src/main/java/com/azbj/fm2002/dto/BlockAlertValidationResponse';

@Injectable({
  providedIn: 'root'
})
export class BlockAlertService {
  private baseUrl = 'http://localhost:8080/api/block-alert';

  constructor(private http: HttpClient) {}

  validateConditions(request: BlockAlertValidationRequest): Observable<BlockAlertValidationResponse> {
    return this.http.post<BlockAlertValidationResponse>(`${this.baseUrl}/validate-conditions`, request);
  }

  unitlink(cn_product_id: string): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/unitlink/${cn_product_id}`);
  }

  validateRadioDispatch(request: BlockAlertValidationRequest): Observable<BlockAlertValidationResponse> {
    return this.http.post<BlockAlertValidationResponse>(`${this.baseUrl}/validate-radio-dispatch`, request);
  }

  updatePolicyStatus(request: BlockAlertValidationRequest): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/update-policy-status`, request);
  }

  validateBackdation(backdationOption: boolean): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/validate-backdation`, { backdationOption });
  }
}
