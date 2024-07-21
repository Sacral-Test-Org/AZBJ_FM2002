import { Component, OnInit } from '@angular/core';
import { PartnerDetailsService } from '../../services/partner-details.service';
import { PartnerDetails } from '../../models/partner-details.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-partner-details',
  templateUrl: './partner-details.component.html',
  styleUrls: ['./partner-details.component.css']
})
export class PartnerDetailsComponent implements OnInit {
  partnerDetails: PartnerDetails;

  constructor(private partnerDetailsService: PartnerDetailsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.partnerDetailsService.getPartnerDetails().subscribe(
      (data: PartnerDetails) => {
        this.partnerDetails = data;
        this.partnerDetails.dateOfBirth = this.formatDate(this.partnerDetails.dateOfBirth);
      },
      (error) => {
        this.logger.error('Error fetching partner details', error);
      }
    );
  }

  private formatDate(date: string): string {
    const d = new Date(date);
    const day = ('0' + d.getDate()).slice(-2);
    const month = ('0' + (d.getMonth() + 1)).slice(-2);
    const year = d.getFullYear();
    return `${day}/${month}/${year}`;
  }
}
