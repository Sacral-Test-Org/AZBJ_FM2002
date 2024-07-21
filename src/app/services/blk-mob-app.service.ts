import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DoctorClientNamesResponse } from '../models/doctor-client-names-response.model';
import { PartnerDetailsDTO } from '../models/partner-details-dto.model';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class BlkMobAppService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  fetchClientNames(doctorCode: string): Observable<DoctorClientNamesResponse> {
    this.logger.debug('Fetching client names for doctor code:', doctorCode);
    return this.http.get<DoctorClientNamesResponse>(`${this.baseUrl}/client-names`, {
      params: { doctorCode }
    });
  }

  fetchPartnerDetails(partnerName: string): Observable<PartnerDetailsDTO> {
    this.logger.debug('Fetching partner details for partner name:', partnerName);
    return this.http.get<PartnerDetailsDTO>(`${this.baseUrl}/partner-details`, {
      params: { partnerName }
    });
  }
}
