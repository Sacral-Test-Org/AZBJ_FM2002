import { Component, OnInit } from '@angular/core';
import { ChildCoverDetailsService } from 'src/app/services/child-cover-details.service';
import { AgeCalculationService } from 'src/app/services/age-calculation.service';

@Component({
  selector: 'app-child-cover-details',
  templateUrl: './child-cover-details.component.html',
  styleUrls: ['./child-cover-details.component.css']
})
export class ChildCoverDetailsComponent implements OnInit {
  childCovers: any[] = [];
  newChild: any = {};
  childNameField: any;

  constructor(
    private childCoverDetailsService: ChildCoverDetailsService,
    private ageCalculationService: AgeCalculationService
  ) {}

  ngOnInit(): void {
    this.focusChildName();
  }

  focusChildName(): void {
    this.childCoverDetailsService.focusChildName();
  }

  addChild(): void {
    this.childCovers.push({ ...this.newChild });
    this.newChild = {};
  }

  deleteChild(index: number): void {
    this.childCovers.splice(index, 1);
  }

  exitSection(): void {
    this.childCoverDetailsService.refreshChildCovers();
    // Hide the Nominee/Child Cover Details view and window
    // Set focus back to the main Child Covers section
  }

  calculateChildAge(childDOB: Date): number {
    const age = this.ageCalculationService.calculateAge(childDOB);
    return age;
  }

  saveChildDetails(): void {
    this.childCoverDetailsService.saveChildDetails(this.childCovers).subscribe();
  }

  handleDobInput(event: Event): void {
    const input = event.target as HTMLInputElement;
    const dob = input.value;
    const age = this.ageCalculationService.calculateAge(dob);
    // Update the age display field
  }

  onExitButtonClick(): void {
    this.exitSection();
  }

  handleChildAgeFocus(): void {
    // Logic to move focus to Child Sum Percentage field
  }
}
