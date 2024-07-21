import { Component } from '@angular/core';
import { PolicyHolderService } from 'src/app/services/policy-holder.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-age-proof-validation',
  templateUrl: './age-proof-validation.component.html',
  styleUrls: ['./age-proof-validation.component.css']
})
export class AgeProofValidationComponent {
  constructor(private policyHolderService: PolicyHolderService, private logger: NGXLogger) {}

  validateAgeProof(ageProofType: string, ageProofID: string, agentCode: string): void {
    this.policyHolderService.validateAgeProof(ageProofType, ageProofID, agentCode).subscribe(
      (response) => {
        if (ageProofType === 'SYBM' && !agentCode.startsWith('522')) {
          alert('Syndicate Bank BM Certificate is allowed only for Syndicate Bank');
        } else if (ageProofType === 'PC') {
          // Enable PAN fields
          this.enablePanFields();
        } else {
          // Disable PAN fields
          this.disablePanFields();
        }

        if (response.PH_AGE_PRF_MSG) {
          this.logger.debug('Age Proof Message:', response.PH_AGE_PRF_MSG);
        }
      },
      (error) => {
        this.logger.error('Error validating age proof:', error);
      }
    );
  }

  private enablePanFields(): void {
    // Logic to enable PAN fields
    const panIssuanceDateField = document.getElementById('PH_PAN_ISSUANCE_DATE');
    const panIssuanceDateNAField = document.getElementById('PH_PAN_ISSUANCE_DATE_NA');
    if (panIssuanceDateField) panIssuanceDateField.removeAttribute('disabled');
    if (panIssuanceDateNAField) panIssuanceDateNAField.removeAttribute('disabled');
  }

  private disablePanFields(): void {
    // Logic to disable PAN fields
    const panIssuanceDateField = document.getElementById('PH_PAN_ISSUANCE_DATE');
    const panIssuanceDateNAField = document.getElementById('PH_PAN_ISSUANCE_DATE_NA');
    if (panIssuanceDateField) panIssuanceDateField.setAttribute('disabled', 'true');
    if (panIssuanceDateNAField) panIssuanceDateNAField.setAttribute('disabled', 'true');
  }
}