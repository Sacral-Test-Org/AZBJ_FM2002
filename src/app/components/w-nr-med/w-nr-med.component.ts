import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FurtherReqService } from 'src/app/services/further-req.service';
import { WNrMedService } from 'src/app/services/w-nr-med.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-w-nr-med',
  templateUrl: './w-nr-med.component.html',
  styleUrls: ['./w-nr-med.component.css']
})
export class WNrMedComponent implements OnInit {
  commentsForm: FormGroup;
  tooltipContent: string = '';

  constructor(
    private fb: FormBuilder,
    private furtherReqService: FurtherReqService,
    private wNrMedService: WNrMedService
  ) {
    this.commentsForm = this.fb.group({
      comments: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  ngOnInit(): void {
    // Initialize the component and ensure the 'Test No' field is disabled by default.
    this.commentsForm.get('testNo')?.disable();
  }

  validateComments(): void {
    const comments = this.commentsForm.get('comments')?.value;
    if (comments.length < 10) {
      alert('Comments should not be less than 10 characters.');
    }
  }

  showTooltip(): void {
    this.furtherReqService.fetchTooltipContent().subscribe((content: string) => {
      this.tooltipContent = content;
    });
  }

  setInsurancePolicyType(productId: number): Observable<any> {
    if ([3, 4, 5, 9, 10].includes(productId)) {
      return this.wNrMedService.setInsurancePolicyType(productId);
    }
    return new Observable(observer => observer.complete());
  }

  onTestNoClick(): void {
    // Navigate to the same field when clicked.
    const testNoField = this.commentsForm.get('testNo');
    if (testNoField) {
      testNoField.markAsTouched();
    }
  }

  onTestNoEnter(): void {
    // Populate the 'Date Called' field with the current date and a specific date from an external API.
    const currentDate = new Date();
    this.wNrMedService.fetchDateFromAPI().subscribe((apiDate: Date) => {
      this.commentsForm.patchValue({ dateCalled: currentDate });
      this.commentsForm.patchValue({ apiDateCalled: apiDate });
    });
  }

  confirmHomeVisit(): void {
    if (confirm('Was the test conducted through a home visit?')) {
      // Allow the user to proceed
    } else {
      this.commentsForm.patchValue({ testConducted: null });
    }
  }

  updateReceiptStatus(receiptStatus: 'Y' | 'N'): void {
    if (receiptStatus === 'Y') {
      const currentDate = new Date();
      this.commentsForm.patchValue({ receiptDate: currentDate });
      this.wNrMedService.updateReceiptStatus({ receiptStatus, receiptDate: currentDate }).subscribe();
    } else if (receiptStatus === 'N') {
      this.commentsForm.patchValue({ receiptDate: null });
      this.wNrMedService.updateReceiptStatus({ receiptStatus, receiptDate: null }).subscribe();
    }
  }
}