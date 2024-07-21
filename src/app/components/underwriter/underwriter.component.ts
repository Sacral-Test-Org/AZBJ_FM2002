import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UnderwriterService } from 'src/app/services/underwriter.service';
import { Observable } from 'rxjs';
import { UnderwriterValidationResponse } from 'src/app/models/underwriter-validation-response.model';

@Component({
  selector: 'app-underwriter',
  templateUrl: './underwriter.component.html',
  styleUrls: ['./underwriter.component.css']
})
export class UnderwriterComponent implements OnInit {
  underwriterId: string;
  underwriterName: string;
  caseInput: string = '';
  currentUser: string = 'CURRENT_USER_ID'; // This should be dynamically set based on the logged-in user

  constructor(private router: Router, private underwriterService: UnderwriterService) {}

  ngOnInit(): void {
    // Initialize the component and fetch underwriter information if needed
    this.underwriterId = 'UNDERWRITER_ID'; // This should be fetched from a service
    this.underwriterName = 'UNDERWRITER_NAME'; // This should be fetched from a service
  }

  onOkClick(): void {
    // Handle the logic when the OK button is clicked
    if (this.caseInput.length > 0 && this.caseInput.length <= 250) {
      console.log('Case forwarded to underwriter:', this.caseInput);
      // Additional logic to forward the case can be added here
    } else {
      console.error('Case input is invalid.');
    }
  }

  onCancelClick(): void {
    // Handle the logic when the Cancel button is clicked
    this.router.navigate(['/main']);
  }

  handleUnderwriterSelection(): void {
    if (this.underwriterId.length !== 8) {
      console.error('Underwriter ID must be exactly 8 characters long.');
      return;
    }
    if (this.underwriterId === this.currentUser) {
      console.error('Selected underwriter cannot be the same as the current user.');
      return;
    }
    this.underwriterService.validateUnderwriter(this.underwriterId).subscribe(
      (response: UnderwriterValidationResponse) => {
        if (response.exists) {
          console.log('Underwriter exists. Case can be forwarded.');
          // Enable the option to save and exit the proposal
          // Display a warning message indicating that the case will be forwarded
        } else {
          console.error('Selected underwriter does not exist.');
        }
      },
      (error) => {
        console.error('Error validating underwriter:', error);
      }
    );
  }
}
