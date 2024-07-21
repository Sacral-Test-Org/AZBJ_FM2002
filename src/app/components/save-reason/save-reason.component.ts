import { Component } from '@angular/core';
import { SaveReasonService } from '../../services/save-reason.service';
import { NgxLoggerLevel, LoggerService } from 'ngx-logger';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-save-reason',
  templateUrl: './save-reason.component.html',
  styleUrls: ['./save-reason.component.css']
})
export class SaveReasonComponent {
  reason: string = '';
  maxReasonLength: number = 4000;

  constructor(private saveReasonService: SaveReasonService, private logger: LoggerService, public dialog: MatDialog) {}

  saveReason(): void {
    if (this.reason.length > this.maxReasonLength) {
      this.logger.log(NgxLoggerLevel.ERROR, 'Reason exceeds maximum length');
      return;
    }
    this.saveReasonService.saveReason(this.reason).subscribe(
      response => {
        this.logger.log(NgxLoggerLevel.INFO, 'Reason saved successfully');
      },
      error => {
        this.logger.log(NgxLoggerLevel.ERROR, 'Error saving reason');
      }
    );
  }

  exitForm(): void {
    const dialogRef = this.dialog.open(ConfirmExitDialog);

    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.saveReasonService.exitForm();
      }
    });
  }
}

@Component({
  selector: 'confirm-exit-dialog',
  template: `
    <h1 mat-dialog-title>Confirm Exit</h1>
    <div mat-dialog-content>Are you sure you want to exit without saving?</div>
    <div mat-dialog-actions>
      <button mat-button (click)="onNoClick()">No</button>
      <button mat-button [mat-dialog-close]="true">Yes</button>
    </div>
  `
})
export class ConfirmExitDialog {
  constructor(public dialogRef: MatDialogRef<ConfirmExitDialog>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
