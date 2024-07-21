import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { PolicyMemberService } from 'src/app/services/policy-member.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-add-member-dialog',
  templateUrl: './add-member-dialog.component.html',
  styleUrls: ['./add-member-dialog.component.css']
})
export class AddMemberDialogComponent {
  memberDetails: any = {};

  constructor(
    private dialogRef: MatDialogRef<AddMemberDialogComponent>,
    private policyMemberService: PolicyMemberService,
    private logger: NGXLogger
  ) {}

  addMember() {
    this.logger.debug('Add Member button pressed');
    this.policyMemberService.addMember(this.memberDetails).subscribe(
      response => {
        this.logger.debug('Member added successfully', response);
        this.dialogRef.close(true);
      },
      error => {
        this.logger.error('Error adding member', error);
        alert('An error occurred while adding the member. Please try again.');
      }
    );
  }

  closeDialog() {
    this.dialogRef.close(false);
  }
}
