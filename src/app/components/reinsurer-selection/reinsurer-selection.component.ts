import { Component, OnInit } from '@angular/core';
import { ReinsurerSelectionService } from 'src/app/services/reinsurer-selection.service';
import { ReinsurerCode } from 'src/app/models/reinsurer-code.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-reinsurer-selection',
  templateUrl: './reinsurer-selection.component.html',
  styleUrls: ['./reinsurer-selection.component.css']
})
export class ReinsurerSelectionComponent implements OnInit {
  reinsurerData: any;
  insurancePolicyTypes: string[] = ['Type1', 'Type2', 'Type3', 'Type4', 'Type5', 'Type6', 'Type7', 'Type8', 'Type9', 'Type10'];
  underwriterRecommendations: string[] = ['Option1', 'Option2', 'Option3', 'Option4', 'Option5'];
  retainAmt: string = '';
  reinsurerCodes: ReinsurerCode[] = [];

  constructor(private reinsurerSelectionService: ReinsurerSelectionService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.reinsurerSelectionService.getReinsurerData().subscribe(
      data => {
        this.reinsurerData = data;
      },
      error => {
        this.logger.error('Error fetching reinsurer data', error);
      }
    );
  }

  onDropdownChange(event: Event): void {
    // Handle dropdown change if required
  }

  deleteRecord(recordId: number): void {
    this.reinsurerSelectionService.deleteRecord(recordId).subscribe(
      response => {
        this.logger.info('Record deleted successfully');
        // Handle successful deletion, e.g., refresh the list
      },
      error => {
        this.logger.error('Error deleting record', error);
      }
    );
  }

  handleRetainAmtInput(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.retainAmt = inputElement.value;
  }

  onReinsuranceTypeDblClick(): void {
    const reinsuranceType = 'someType'; // Replace with actual value
    const productId = 'someProductId'; // Replace with actual value
    const coverCode = 'someCoverCode'; // Replace with actual value

    this.reinsurerSelectionService.getReinsurerCodes(reinsuranceType, productId, coverCode).subscribe(
      reinsurerCodes => {
        this.displayReinsurerCodes(reinsurerCodes);
      },
      error => {
        this.handleError(error);
      }
    );
  }

  displayReinsurerCodes(reinsurerCodes: ReinsurerCode[]): void {
    this.reinsurerCodes = reinsurerCodes;
  }

  handleError(error: any): void {
    this.logger.error('Error retrieving reinsurer codes', error);
  }
}
