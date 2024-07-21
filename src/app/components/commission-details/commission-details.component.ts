import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommissionDetailsService } from '../../services/commission-details.service';
import { CommissionDetails } from '../../models/commission-details.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-commission-details',
  templateUrl: './commission-details.component.html',
  styleUrls: ['./commission-details.component.css']
})
export class CommissionDetailsComponent implements OnInit {
  commissionDetails: CommissionDetails;
  agentCode: string;

  constructor(
    private route: ActivatedRoute,
    private commissionDetailsService: CommissionDetailsService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.agentCode = this.route.snapshot.paramMap.get('agentCode');
    if (this.agentCode) {
      this.getCommissionDetails(this.agentCode);
    } else {
      this.logger.error('Agent code is missing in the route parameters');
    }
  }

  getCommissionDetails(agentCode: string): void {
    this.commissionDetailsService.getCommissionDetails(agentCode).subscribe(
      (data: CommissionDetails) => {
        this.commissionDetails = data;
      },
      (error) => {
        this.logger.error('Error fetching commission details', error);
      }
    );
  }
}
