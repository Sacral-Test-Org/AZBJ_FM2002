import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {

  constructor(public dialogRef: MatDialogRef<ConfirmationDialogComponent>) {}

  confirm(): void {
    const userConfirmed = confirm('Was the test conducted through a home visit?');
    if (userConfirmed) {
      this.dialogRef.close(true);
    } else {
      this.dialogRef.close(false);
    }
  }
}
