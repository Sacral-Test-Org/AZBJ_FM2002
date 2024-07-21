import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-risk-details',
  templateUrl: './risk-details.component.html',
  styleUrls: ['./risk-details.component.css']
})
export class RiskDetailsComponent implements OnInit {
  riskDetails: any = {};
  readonlyFields: string[] = [
    'policyNumber', 'contractId', 'sumAssured', 'dateOfRisk', 'productName',
    'annualPremium', 'termOfAcceptance', 'timeStamp', 'paidBy',
    'mainCoverRatedUp', 'reasonForRating', 'value', 'riderCoverRatedUp', 'bt', 'pt'
  ];

  constructor(private http: HttpClient, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.fetchRiskDetails();
  }

  fetchRiskDetails(): void {
    this.http.get('/api/risk-details').subscribe(
      data => {
        this.riskDetails = data;
        this.logger.info('Risk details fetched successfully');
      },
      error => {
        this.logger.error('Error fetching risk details', error);
      }
    );
  }

  viewImages(): void {
    // Logic to view images
    this.logger.info('View images button clicked');
  }

  viewAdverseFactors(): void {
    // Logic to view adverse factors
    this.logger.info('View adverse factors button clicked');
  }
}
