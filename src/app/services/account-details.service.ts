import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BankDetails, AccountDetails } from '../models/account-details.model';

@Injectable({
  providedIn: 'root'
})
export class AccountDetailsService {
  private baseUrl = '/api/account-details';

  constructor(private http: HttpClient) {}

  getBankDetails(ifscCode: string): Observable<BankDetails> {
    const params = new HttpParams().set('ifscCode', ifscCode);
    return this.http.get<BankDetails>(`${this.baseUrl}/bank-details`, { params });
  }

  saveAccountDetails(accountDetails: AccountDetails): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/save`, accountDetails);
  }

  fetchBankDetails(ifscCode: string): Observable<BankDetails> {
    return this.getBankDetails(ifscCode);
  }

  getSameBankDetails(params: { accountNumber: string, ifscCode: string, formName: string, insuredPersonId: string, policyHolderId: string }): Observable<any> {
    const httpParams = new HttpParams()
      .set('accountNumber', params.accountNumber)
      .set('ifscCode', params.ifscCode)
      .set('formName', params.formName)
      .set('insuredPersonId', params.insuredPersonId)
      .set('policyHolderId', params.policyHolderId);
    return this.http.get<any>(`${this.baseUrl}/same-bank-details`, { params: httpParams });
  }
}
