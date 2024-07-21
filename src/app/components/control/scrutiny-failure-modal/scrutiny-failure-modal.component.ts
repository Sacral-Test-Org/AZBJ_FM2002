import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-scrutiny-failure-modal',
  templateUrl: './scrutiny-failure-modal.component.html',
  styleUrls: ['./scrutiny-failure-modal.component.css']
})
export class ScrutinyFailureModalComponent implements OnInit {
  scrutinyForm: FormGroup;
  reasons: string[] = ['Reason 1', 'Reason 2', 'Reason 3', 'Reason 4', 'Reason 5'];
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private router: Router) {
    this.scrutinyForm = this.fb.group({
      reason: ['', [Validators.required, Validators.maxLength(200)]],
      documentDescription: [''],
      requiredDocumentsReceived: ['Y'],
      additionalComments: ['']
    });
  }

  ngOnInit(): void {
    // Initialize form fields with default values
  }

  insertReason(reason: string): void {
    if (this.reasons.length < 5) {
      this.reasons.push(reason);
    } else {
      this.displayErrorMessage('Cannot add more than 5 reasons.');
    }
  }

  updateReason(reason: string): void {
    const index = this.reasons.indexOf(reason);
    if (index !== -1) {
      this.reasons[index] = reason;
    } else {
      this.displayErrorMessage('Reason not found.');
    }
  }

  save(): void {
    // Handle the save action, initially disabled
  }

  update(): void {
    // Handle the update action, enabled
  }

  exit(): void {
    this.router.navigate(['/main-menu']);
  }

  onExitButtonClick(): void {
    this.exit();
  }

  displayErrorMessage(errorMessage: string): void {
    this.errorMessage = errorMessage;
  }
}
