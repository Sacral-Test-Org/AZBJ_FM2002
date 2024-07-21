import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent {
  @Output() confirm = new EventEmitter<void>();
  @Output() cancel = new EventEmitter<void>();

  confirmUpdate(): void {
    if (confirm('Do you wish to continue generating a report for the fake document?')) {
      this.confirm.emit();
    } else {
      this.cancel.emit();
    }
  }
}
