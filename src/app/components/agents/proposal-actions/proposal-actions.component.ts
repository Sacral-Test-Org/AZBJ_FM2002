import { Component, OnInit } from '@angular/core';
import { AgentsService } from 'src/app/services/agents.service';
import { ProposalActionsDTO } from 'src/app/models/proposal-actions-dto.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-proposal-actions',
  templateUrl: './proposal-actions.component.html',
  styleUrls: ['./proposal-actions.component.css']
})
export class ProposalActionsComponent implements OnInit {
  proposalActions: ProposalActionsDTO;

  constructor(private agentsService: AgentsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.getProposalActions();
  }

  getProposalActions(): void {
    this.agentsService.getProposalActions().subscribe(
      (data: ProposalActionsDTO) => {
        this.proposalActions = data;
        this.logger.info('Proposal actions fetched successfully', data);
        // Additional logic to update the UI based on fetched data
      },
      (error) => {
        this.logger.error('Error fetching proposal actions', error);
      }
    );
  }

  updateProposalActions(proposalActionsDTO: ProposalActionsDTO): void {
    this.agentsService.updateProposalActions(proposalActionsDTO).subscribe(
      (response) => {
        this.logger.info('Proposal actions updated successfully', response);
        // Additional logic to update the UI based on response
      },
      (error) => {
        this.logger.error('Error updating proposal actions', error);
      }
    );
  }
}
