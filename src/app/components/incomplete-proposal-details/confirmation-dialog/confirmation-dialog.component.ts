import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {

  constructor(public dialogRef: MatDialogRef<ConfirmationDialogComponent>) {}

  showConfirmationDialog(): void {
    // Logic to display the confirmation dialog
    this.dialogRef.open(ConfirmationDialogComponent);
  }

  onConfirm(): void {
    // Logic to set a flag indicating that the incomplete proposal details have been saved
    console.log('Incomplete proposal details have been saved.');
    this.dialogRef.close(true);
  }

  onCancel(): void {
    // Logic to raise an error to halt the process
    console.error('Action cancelled. Incomplete proposal details have not been saved.');
    this.dialogRef.close(false);
  }
}
