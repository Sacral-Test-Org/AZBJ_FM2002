import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BeneficiaryDTO, TrusteeDTO, BeneficiaryTrusteeInfo } from '../models/mwp-act.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class MwpActService {
  private baseUrl = '/api/mwp-act';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  getBeneficiaries(): Observable<BeneficiaryDTO[]> {
    this.logger.debug('Fetching beneficiaries');
    return this.http.get<BeneficiaryDTO[]>(`${this.baseUrl}/beneficiaries`);
  }

  getTrustees(): Observable<TrusteeDTO[]> {
    this.logger.debug('Fetching trustees');
    return this.http.get<TrusteeDTO[]>(`${this.baseUrl}/trustees`);
  }

  saveBeneficiary(beneficiary: BeneficiaryDTO): Observable<void> {
    this.logger.debug('Saving beneficiary', beneficiary);
    return this.http.post<void>(`${this.baseUrl}/beneficiary`, beneficiary);
  }

  saveTrustee(trustee: TrusteeDTO): Observable<void> {
    this.logger.debug('Saving trustee', trustee);
    return this.http.post<void>(`${this.baseUrl}/trustee`, trustee);
  }

  saveBeneficiaryTrusteeInfo(info: BeneficiaryTrusteeInfo): Observable<any> {
    this.logger.debug('Saving beneficiary and trustee information', info);
    return this.http.post<any>(`${this.baseUrl}/saveBeneficiaryTrusteeInfo`, info);
  }
}
