import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PANApprovalService } from 'src/app/services/pan-approval.service';

@Component({
  selector: 'app-pan-approval',
  templateUrl: './pan-approval.component.html',
  styleUrls: ['./pan-approval.component.css']
})
export class PANApprovalComponent implements OnInit {
  panApprovalForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private panApprovalService: PANApprovalService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.panApprovalForm = this.fb.group({
      ageProof: ['', Validators.required],
      ageProofId: ['', Validators.required],
      panIssuanceDate: ['', Validators.required],
      uwReason: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9 ]*$/)]],
      supervisorComment: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9 ]*$/)]]
    });
  }

  onSupervisorApproval(): void {
    if (this.validateFields()) {
      const formData = this.panApprovalForm.value;
      this.panApprovalService.approvePAN(formData).subscribe(
        response => {
          // Handle success response
          console.log('Approval successful', response);
        },
        error => {
          // Handle error response
          console.error('Approval failed', error);
        }
      );
    }
  }

  onExit(): void {
    this.router.navigate(['/client-environment-validation']);
  }

  validateFields(): boolean {
    if (!this.panApprovalForm.get('uwReason').valid || !this.panApprovalForm.get('supervisorComment').valid) {
      alert('UW Reason and Supervisor Comment must not contain special characters and cannot be empty.');
      return false;
    }
    return true;
  }

  onExitButtonClick(): void {
    this.onExit();
  }
}
