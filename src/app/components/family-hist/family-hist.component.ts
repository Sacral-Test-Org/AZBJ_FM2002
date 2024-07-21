import { Component } from '@angular/core';
import { ValidationErrorComponent } from './validation-error/validation-error.component';
import { FamilyHistService } from 'src/app/services/family-hist.service';

@Component({
  selector: 'app-family-hist',
  templateUrl: './family-hist.component.html',
  styleUrls: ['./family-hist.component.css']
})
export class FamilyHistComponent {
  age: number;
  ageDied: number;
  causeOfDeathOptions: string[] = [
    'Heart Attack', 'Cancer', 'Stroke', 'Accident', 'Diabetes', 'Alzheimer', 'Kidney Failure', 'Liver Disease', 'Pneumonia', 'Suicide', 'Homicide', 'Other'
  ];
  selectedFamilyMember: string;
  familyMembers: string[] = ['Father', 'Mother', 'Brother', 'Sister', 'Uncle', 'Aunt', 'Grandfather', 'Grandmother'];

  constructor(private familyHistService: FamilyHistService) {}

  validateAge(age: number): void {
    if (age < 0) {
      ValidationErrorComponent.showError('Age Entered cannot be less than Zero.');
    }
  }

  validateAgeDied(ageDied: number): void {
    if (ageDied < 0) {
      ValidationErrorComponent.showError('Age Entered cannot be less than Zero.');
    }
  }

  handleDropdownSelection(selectedFamilyMember: string): void {
    this.selectedFamilyMember = selectedFamilyMember;
    // Save the selected family member logic here
  }

  deleteMember(memberId: number): void {
    this.familyHistService.deleteMember(memberId).subscribe(
      response => {
        // Handle successful deletion
        console.log('Member deleted successfully');
      },
      error => {
        // Handle error
        console.error('Error deleting member');
      }
    );
  }
}
