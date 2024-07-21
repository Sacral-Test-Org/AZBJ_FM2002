import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {
  @Output() confirmDelete = new EventEmitter<void>();
  @Output() cancelDelete = new EventEmitter<void>();

  confirm(): void {
    // Emit the confirmDelete event to notify parent component to proceed with deletion
    this.confirmDelete.emit();
  }

  cancel(): void {
    // Emit the cancelDelete event to notify parent component to cancel deletion
    this.cancelDelete.emit();
  }
}
