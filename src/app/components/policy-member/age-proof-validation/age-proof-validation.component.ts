import { Component } from '@angular/core';
import { PolicyMemberService } from 'src/app/services/policy-member.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-age-proof-validation',
  templateUrl: './age-proof-validation.component.html',
  styleUrls: ['./age-proof-validation.component.css']
})
export class AgeProofValidationComponent {
  ageProofs: any[] = [];
  selectedAgeProofDetails: any = null;

  constructor(private policyMemberService: PolicyMemberService, private logger: NGXLogger) {}

  showAgeProofList() {
    this.policyMemberService.getAgeProofList().subscribe(
      (data: any[]) => {
        this.ageProofs = data;
      },
      (error) => {
        this.logger.error('Error fetching age proof list', error);
        this.ageProofs = [];
      }
    );
  }

  selectAgeProof(proofType: string) {
    this.policyMemberService.getAgeProofDetails(proofType).subscribe(
      (data: any) => {
        if (data) {
          this.selectedAgeProofDetails = data;
        } else {
          this.selectedAgeProofDetails = 'NA';
        }
      },
      (error) => {
        this.logger.error('Error fetching age proof details', error);
        this.selectedAgeProofDetails = 'NA';
      }
    );
  }
}
