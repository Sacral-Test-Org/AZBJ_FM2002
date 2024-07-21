import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-kyc-download',
  templateUrl: './kyc-download.component.html',
  styleUrls: ['./kyc-download.component.css']
})
export class KycDownloadComponent {
  kycResponse: any;

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  displayKycResponse(response: any): void {
    this.kycResponse = response;
    this.logger.info('KYC Response:', response);
    alert('KYC Response: ' + JSON.stringify(response, null, 2));
  }

  downloadKyc(): void {
    // This method will be implemented to trigger the KYC download process
  }
}
