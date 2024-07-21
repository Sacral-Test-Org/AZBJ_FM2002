import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-driving-license-details',
  templateUrl: './driving-license-details.component.html',
  styleUrls: ['./driving-license-details.component.css']
})
export class DrivingLicenseDetailsComponent implements OnInit {
  insuredPersonDetails: any;
  policyHolderDetails: any;
  warningMessage: string = '';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.fetchDrivingLicenseDetails();
  }

  fetchDrivingLicenseDetails(): void {
    // Mock data for demonstration purposes
    const insuredPersonSignCardNumber = '123456789';
    const policyHolderVerificationNumber = '987654321';

    this.http.get(`/api/driving-license-details?signCardNumber=${insuredPersonSignCardNumber}&verificationNumber=${policyHolderVerificationNumber}`)
      .subscribe((response: any) => {
        this.insuredPersonDetails = response.insuredPerson;
        this.policyHolderDetails = response.policyHolder;

        if (!this.insuredPersonDetails.drivingLicenseNumber && !this.policyHolderDetails.drivingLicenseNumber) {
          this.warningMessage = 'Driving license details are not selected for the insured person or policyholder.';
        } else {
          this.displayDrivingLicenseDetails();
        }
      }, error => {
        this.logger.error('Error fetching driving license details', error);
      });
  }

  displayDrivingLicenseDetails(): void {
    // Logic to display driving license details
    this.logger.info('Displaying driving license details for insured person and policyholder');
  }
}
