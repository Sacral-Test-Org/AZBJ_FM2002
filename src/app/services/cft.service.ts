import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

interface BeneficialOwnershipDetails {
  beneficial_owner: string;
  beb_owner_share: number;
  color_photo: string;
  identity_proof_desc: string;
  identity_doc_id: string;
  identity_doc_date: string;
  address_proof_desc: string;
  address_doc_id: string;
  address_doc_date: string;
  address: string;
  individual_shareholding: number;
  family_shareholdings: number;
  date_of_birth: string;
}

@Injectable({
  providedIn: 'root'
})
export class CFTService {
  private apiUrl = 'http://your-api-url.com';

  constructor(private http: HttpClient) {}

  resetCFTData(): void {
    // Logic to reset CFT data
    this.http.post(`${this.apiUrl}/reset-cft`, {}).subscribe();
  }

  retrieveBeneficialOwnershipDetails(contractId: string): Observable<BeneficialOwnershipDetails> {
    return this.http.get<BeneficialOwnershipDetails>(`${this.apiUrl}/beneficial-ownership/${contractId}`)
      .pipe(catchError(this.handleException));
  }

  handleException(error: any): Observable<never> {
    // Logic to handle exceptions
    console.error('An error occurred', error);
    return throwError('Something bad happened; please try again later.');
  }
}
