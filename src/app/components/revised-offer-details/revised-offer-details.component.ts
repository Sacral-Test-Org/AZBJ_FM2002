import { Component, OnInit } from '@angular/core';
import { RevisedOfferDetailsService } from 'src/app/services/revised-offer-details.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-revised-offer-details',
  templateUrl: './revised-offer-details.component.html',
  styleUrls: ['./revised-offer-details.component.css']
})
export class RevisedOfferDetailsComponent implements OnInit {
  revisedOfferDetails: any;

  constructor(private revisedOfferDetailsService: RevisedOfferDetailsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.fetchRevisedOfferDetails();
  }

  fetchRevisedOfferDetails(): void {
    this.revisedOfferDetailsService.getRevisedOfferDetails().subscribe(
      data => {
        this.revisedOfferDetails = data;
        this.logger.info('Revised offer details fetched successfully', data);
      },
      error => {
        this.logger.error('Error fetching revised offer details', error);
      }
    );
  }
}
