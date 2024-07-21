import { Component, OnInit } from '@angular/core';
import { PolicyHolderService } from '../../services/policy-holder.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-proposal-type-lov',
  templateUrl: './proposal-type-lov.component.html',
  styleUrls: ['./proposal-type-lov.component.css']
})
export class ProposalTypeLovComponent implements OnInit {
  proposalTypes: any[] = [];
  displayLOV: boolean = false;

  constructor(private policyHolderService: PolicyHolderService, private logger: NGXLogger) { }

  ngOnInit(): void {
    // Initialization logic if needed
  }

  showLOV(): void {
    this.logger.debug('Fetching proposal types for LOV');
    this.policyHolderService.fetchProposalTypes().subscribe(
      (data: any[]) => {
        this.proposalTypes = data;
        this.displayLOV = true;
        this.logger.debug('Proposal types fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching proposal types', error);
      }
    );
  }
}
