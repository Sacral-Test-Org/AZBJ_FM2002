import { Component, OnInit } from '@angular/core';
import { PassportDetailsService } from 'src/app/services/passport-details.service';
import { PassportDetailsDTO } from 'src/app/models/passport-details.dto';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-passport-details',
  templateUrl: './passport-details.component.html',
  styleUrls: ['./passport-details.component.css']
})
export class PassportDetailsComponent implements OnInit {
  passportDetails: PassportDetailsDTO;
  warningMessage: string;

  constructor(private passportDetailsService: PassportDetailsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    // Initialization logic if needed
  }

  displayPassportDetails(passportDetailsDTO: PassportDetailsDTO): void {
    this.passportDetailsService.getPassportDetails(passportDetailsDTO).subscribe(
      (data: PassportDetailsDTO) => {
        this.passportDetails = data;
        if (!this.passportDetails.insuredPersonPassport && !this.passportDetails.policyHolderPassport) {
          this.warningMessage = 'Passport details are not selected for either the insured person or the policy holder.';
        } else {
          this.warningMessage = '';
        }
      },
      (error) => {
        this.logger.error('Error fetching passport details', error);
        this.warningMessage = 'An error occurred while fetching passport details.';
      }
    );
  }
}
