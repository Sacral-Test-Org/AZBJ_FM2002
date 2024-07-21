import { Component, OnInit } from '@angular/core';
import { ScrutinyFailService } from 'src/app/services/scrutiny-fail.service';
import { ConfirmationDialogComponent } from 'src/app/components/confirmation-dialog/confirmation-dialog.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-scrutiny-fail',
  templateUrl: './scrutiny-fail.component.html',
  styleUrls: ['./scrutiny-fail.component.css']
})
export class ScrutinyFailComponent implements OnInit {
  documentDescription: string = '';
  commentsFieldEditable: boolean = false;
  documentReceiptStatus: string = 'Yes';

  constructor(private scrutinyFailService: ScrutinyFailService) {}

  ngOnInit(): void {
    this.scrutinyFailService.getDocumentReceiptStatus().subscribe(status => {
      this.documentReceiptStatus = status || 'Yes';
    });
  }

  updateCommentsFieldState(description: string): void {
    this.commentsFieldEditable = description === 'Others';
  }

  onDocumentDescriptionChange(event: Event): void {
    const description = (event.target as HTMLInputElement).value;
    this.updateCommentsFieldState(description);
  }

  handleDocumentReceiptStatusChange(event: Event): void {
    const status = (event.target as HTMLInputElement).value;
    this.scrutinyFailService.saveDocumentReceiptStatus(status);
  }

  onUpdateButtonClick(): void {
    if (confirm('Are You Sure? You Want To Update the Scrutiny Fail document details?')) {
      const scrutinyFailDetails = this.collectScrutinyFailDetails();
      this.scrutinyFailService.updateScrutinyFailDetails(scrutinyFailDetails).subscribe(
        () => alert('Update successful'),
        error => alert('Error: ' + error)
      );
    }
  }

  private collectScrutinyFailDetails(): any {
    // Collect the details from the form or component state
    return {
      documentChecked: this.documentDescription,
      updateUser: 'currentUserId', // Replace with actual user ID
      updateDt: new Date(),
      comments: this.commentsFieldEditable ? 'some comments' : '' // Replace with actual comments
    };
  }
}