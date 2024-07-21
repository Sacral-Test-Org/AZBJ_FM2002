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

  displayPassportDetails(details: PassportDetailsDTO): void {
    this.logger.debug('Displaying passport details', details);
    if (details) {
      this.passportDetails = details;
      this.warningMessage = '';
    } else {
      this.warningMessage = 'Passport details are not selected for either the insured person or the policy holder.';
    }
  }

  fetchPassportDetails(applicationNumber: string): void {
    this.passportDetailsService.getPassportDetails(applicationNumber).subscribe(
      (details: PassportDetailsDTO) => {
        this.displayPassportDetails(details);
      },
      (error) => {
        this.logger.error('Error fetching passport details', error);
        this.warningMessage = 'Error fetching passport details. Please try again later.';
      }
    );
  }
}
