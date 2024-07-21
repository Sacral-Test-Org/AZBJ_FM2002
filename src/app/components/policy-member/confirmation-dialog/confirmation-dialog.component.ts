import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {
  @Output() confirmDeletion = new EventEmitter<void>();
  @Output() cancelDeletion = new EventEmitter<void>();

  onConfirmClick(): void {
    this.confirmDeletion.emit();
  }

  onCancelClick(): void {
    this.cancelDeletion.emit();
  }
}
