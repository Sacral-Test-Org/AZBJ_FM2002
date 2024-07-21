import { Component, OnInit } from '@angular/core';
import { PolicyHolderService } from 'src/app/services/policy-holder.service';
import { EiaDetailsDTO } from 'src/app/models/eia-details-dto.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-eia-details',
  templateUrl: './eia-details.component.html',
  styleUrls: ['./eia-details.component.css']
})
export class EiaDetailsComponent implements OnInit {
  eiaDetails: EiaDetailsDTO;
  applicationNumber: string = '123456'; // This should be dynamically set based on the context

  constructor(private policyHolderService: PolicyHolderService) { }

  ngOnInit(): void {
    this.getEiaDetails();
  }

  getEiaDetails(): void {
    this.policyHolderService.getEiaDetails(this.applicationNumber).subscribe(
      (data: EiaDetailsDTO) => {
        this.eiaDetails = data;
        this.checkEIAAccountOpening();
      },
      (error) => {
        console.error('Error fetching EIA details', error);
      }
    );
  }

  checkEIAAccountOpening(): void {
    if (this.eiaDetails && this.eiaDetails.eiaAccountType === 'New_Applicant') {
      // Enable EI Account Opening field
      console.log('EI Account Opening field enabled');
    } else {
      // Disable EI Account Opening field
      console.log('EI Account Opening field disabled');
    }
  }
}
