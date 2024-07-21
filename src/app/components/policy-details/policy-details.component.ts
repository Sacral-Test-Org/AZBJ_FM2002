import { Component, OnInit } from '@angular/core';
import { PolicyDetailsService } from 'src/app/services/policy-details.service';
import { PolicyDetailsDTO } from 'src/app/models/policy-details-dto.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-policy-details',
  templateUrl: './policy-details.component.html',
  styleUrls: ['./policy-details.component.css']
})
export class PolicyDetailsComponent implements OnInit {
  policyDetails: PolicyDetailsDTO | null = null;
  errorMessage: string = '';

  constructor(private policyDetailsService: PolicyDetailsService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.viewPolicyDetails('insuredPersonId');
  }

  viewPolicyDetails(insuredPersonId: string): void {
    this.clearPolicyDetails();
    this.policyDetailsService.getPolicyDetails(insuredPersonId).subscribe({
      next: (data: PolicyDetailsDTO) => {
        this.policyDetails = data;
        this.calculatePremiumAndInceptionDate();
        this.calculateReinsuranceDetails();
      },
      error: (err) => {
        this.errorMessage = 'Error fetching policy details';
        this.logger.error('Error fetching policy details', err);
      }
    });
  }

  clearPolicyDetails(): void {
    this.policyDetails = null;
  }

  calculatePremiumAndInceptionDate(): void {
    if (this.policyDetails) {
      // Assuming premiumAmount and inceptionDate are calculated here
      this.policyDetails.premiumAmount = this.policyDetails.annualPremium * 1.1; // Example calculation
      this.policyDetails.inceptionDate = new Date(); // Example calculation
    }
  }

  calculateReinsuranceDetails(): void {
    if (this.policyDetails) {
      // Assuming reinsurance details are calculated here
      this.policyDetails.reinsuranceDetails = 'Calculated Reinsurance Details'; // Example calculation
    }
  }
}