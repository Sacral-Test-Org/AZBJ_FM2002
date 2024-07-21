import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SpouseFinancialDetailsDTO } from '../models/spouse-financial-details.dto';
import { NGXLogger } from 'ngx-logger';

@Injectable({
  providedIn: 'root'
})
export class SpouseFinancialDetailsService {
  private apiUrl = 'http://localhost:8080/api/spouse-financial-details';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  saveSpouseFinancialDetails(details: SpouseFinancialDetailsDTO): Observable<SpouseFinancialDetailsDTO> {
    this.logger.debug('Saving spouse financial details', details);
    return this.http.post<SpouseFinancialDetailsDTO>(this.apiUrl, details);
  }
}
