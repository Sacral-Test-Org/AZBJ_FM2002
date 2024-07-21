import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IibDetailsService } from 'src/app/services/iib-details.service';
import { IibDetails } from 'src/app/models/iib-details.model';

@Component({
  selector: 'app-iib-details',
  templateUrl: './iib-details.component.html',
  styleUrls: ['./iib-details.component.css']
})
export class IibDetailsComponent implements OnInit {
  policyDetails: IibDetails[] = [];
  currentRecordIndex: number = 0;
  transactionId: string = 'current_transaction_id'; // This should be dynamically set based on the context

  constructor(private iibDetailsService: IibDetailsService, private router: Router) {}

  ngOnInit(): void {
    this.getIibMatchedDetails();
  }

  getIibMatchedDetails(): void {
    this.iibDetailsService.getIibMatchedDetails(this.transactionId).subscribe((details: IibDetails[]) => {
      this.policyDetails = details;
      if (this.policyDetails.length > 0) {
        this.currentRecordIndex = 0;
        this.populateIibDetails(this.policyDetails[this.currentRecordIndex]);
      }
    });
  }

  populateIibDetails(detail: IibDetails): void {
    // Populate the IIB details block with the retrieved data
    // Fetch and display descriptions for POLICY_STATUS, COMPANY_NUMBER, and CAUSE_OF_DEATH
    // This logic should be implemented based on the actual data structure and requirements
  }

  editPolicyDetail(policyDetail: IibDetails): void {
    this.iibDetailsService.updatePolicyDetail(policyDetail).subscribe(() => {
      // Handle successful update
    });
  }

  navigateRecords(direction: string): void {
    if (direction === 'next' && this.currentRecordIndex < this.policyDetails.length - 1) {
      this.currentRecordIndex++;
    } else if (direction === 'previous' && this.currentRecordIndex > 0) {
      this.currentRecordIndex--;
    }
    this.populateIibDetails(this.policyDetails[this.currentRecordIndex]);
  }

  onBackButtonClick(): void {
    this.router.navigate(['/agents']);
  }

  hideCanIibDet(): void {
    // Logic to hide the 'CAN_IIB_DET' view
  }
}