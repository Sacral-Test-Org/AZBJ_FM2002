import { Component, OnInit } from '@angular/core';
import { RiskScoreDetailsService } from 'src/app/services/risk-score-details.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-risk-score-details',
  templateUrl: './risk-score-details.component.html',
  styleUrls: ['./risk-score-details.component.css']
})
export class RiskScoreDetailsComponent implements OnInit {
  riskScoreDetails: any[] = [];

  constructor(private riskScoreDetailsService: RiskScoreDetailsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.getRiskScoreDetails();
  }

  getRiskScoreDetails(): void {
    this.riskScoreDetailsService.getRiskScoreDetails().subscribe(
      (data: any[]) => {
        this.riskScoreDetails = data;
        this.logger.info('Risk score details fetched successfully');
      },
      (error) => {
        this.logger.error('Error fetching risk score details', error);
      }
    );
  }

  addRiskScoreDetail(riskScoreDetail: any): void {
    this.riskScoreDetailsService.addRiskScoreDetail(riskScoreDetail).subscribe(
      (data: any) => {
        this.riskScoreDetails.push(data);
        this.logger.info('Risk score detail added successfully');
      },
      (error) => {
        this.logger.error('Error adding risk score detail', error);
      }
    );
  }

  updateRiskScoreDetail(riskScoreDetail: any): void {
    this.riskScoreDetailsService.updateRiskScoreDetail(riskScoreDetail).subscribe(
      (data: any) => {
        const index = this.riskScoreDetails.findIndex(item => item.id === data.id);
        if (index !== -1) {
          this.riskScoreDetails[index] = data;
          this.logger.info('Risk score detail updated successfully');
        }
      },
      (error) => {
        this.logger.error('Error updating risk score detail', error);
      }
    );
  }
}
