import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent implements OnInit {
  selectedOption: string = 'CE';
  options: string[] = ['CE', 'Option1', 'Option2'];

  constructor(public dialogRef: MatDialogRef<ConfirmationDialogComponent>) {}

  ngOnInit(): void {
    // Initialize the radio group with a default value
    this.selectedOption = 'CE';
  }

  onOk(): void {
    // Handle the logic when the Ok button is clicked
    this.confirmSelection();
  }

  onCancel(): void {
    // Handle the logic when the Cancel button is clicked
    this.dialogRef.close();
  }

  confirmSelection(): void {
    // Handle the user's selection and close the dialog automatically after confirmation
    this.dialogRef.close(this.selectedOption);
  }
}