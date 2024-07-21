import { Component, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {
  @Input() userId: string;
  @Output() confirm = new EventEmitter<void>();
  @Output() cancel = new EventEmitter<void>();

  confirmDelete(): void {
    if (this.userId) {
      this.confirm.emit();
    }
  }

  cancelDelete(): void {
    this.cancel.emit();
  }
}