import { Component, OnInit } from '@angular/core';
import { NewBusinessService } from 'src/app/services/new-business.service';
import { LifeStyleService } from 'src/app/services/life-style.service';

@Component({
  selector: 'app-new-business',
  templateUrl: './new-business.component.html',
  styleUrls: ['./new-business.component.css']
})
export class NewBusinessComponent implements OnInit {
  userId: string;
  effectiveDate: Date;
  reasonCode: string;
  abortMovement: boolean;
  relationshipDetails: string[] = [];
  partnerOptions: string[] = ['Option 1', 'Option 2', 'Option 3'];
  lifestyleDefault: string = 'S';

  constructor(private newBusinessService: NewBusinessService, private lifeStyleService: LifeStyleService) {}

  ngOnInit(): void {
    this.initializeTabs();
    this.initializeToolbar();
    this.initializeLifestyleRadioGroup();
    this.initializePartnerSelectionField();
  }

  initializeTabs(): void {
    // Logic to initialize tabs
  }

  initializeToolbar(): void {
    // Logic to initialize toolbar with user information and date
  }

  initializeLifestyleRadioGroup(): void {
    this.lifeStyleService.getDefaultValue().subscribe((value: string) => {
      this.lifestyleDefault = value;
    });
  }

  initializePartnerSelectionField(): void {
    // Logic to initialize partner selection field with predefined options
  }

  handleTextFieldInput(event: KeyboardEvent): void {
    const input = event.target as HTMLInputElement;
    if (input.value.length > 1000) {
      input.value = input.value.substring(0, 1000);
    }
    if (event.key === 'ArrowDown') {
      this.moveToNextItem();
    }
  }

  moveToNextItem(): void {
    // Logic to move cursor to the next item in the form
  }

  addRelationshipDetails(relationshipDetail: string): void {
    this.newBusinessService.addRelationshipDetail(relationshipDetail).subscribe(() => {
      this.getRelationshipDetails();
    });
  }

  updateRelationshipDetails(id: number, relationshipDetail: string): void {
    this.newBusinessService.updateRelationshipDetail(id, relationshipDetail).subscribe(() => {
      this.getRelationshipDetails();
    });
  }

  getRelationshipDetails(): void {
    this.newBusinessService.getRelationshipDetails().subscribe((details: string[]) => {
      this.relationshipDetails = details;
    });
  }
}