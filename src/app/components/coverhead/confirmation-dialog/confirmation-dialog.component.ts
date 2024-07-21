import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {
  @Output() toggleReasonField = new EventEmitter<boolean>();
  @Output() resetRetentionFlag = new EventEmitter<void>();

  message: string;

  confirm(message: string): boolean {
    this.message = message;
    return confirm(this.message);
  }

  confirmAction(): void {
    this.toggleReasonField.emit(true);
  }

  cancelAction(): void {
    this.toggleReasonField.emit(false);
    this.resetRetentionFlag.emit();
  }
}