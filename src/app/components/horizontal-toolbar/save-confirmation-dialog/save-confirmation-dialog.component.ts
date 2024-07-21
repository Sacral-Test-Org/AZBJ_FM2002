import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-save-confirmation-dialog',
  templateUrl: './save-confirmation-dialog.component.html',
  styleUrls: ['./save-confirmation-dialog.component.css']
})
export class SaveConfirmationDialogComponent {

  constructor(public dialogRef: MatDialogRef<SaveConfirmationDialogComponent>) {}

  confirmSave(): void {
    const confirmation = confirm('Are you sure you want to save the changes?');
    if (confirmation) {
      this.saveChanges();
    }
  }

  private saveChanges(): void {
    // Logic to save changes to the database
    // This method will include all the necessary validations and conditions as per the user story
    // For now, we will just log a message
    console.log('Changes have been saved successfully.');
    this.dialogRef.close();
  }
}
