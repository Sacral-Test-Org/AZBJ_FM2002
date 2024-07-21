import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { EndMovement1Service } from 'src/app/services/end-movement1.service';
import { ConfirmationDialogComponent } from 'src/app/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-end-movement1',
  templateUrl: './end-movement1.component.html',
  styleUrls: ['./end-movement1.component.css']
})
export class EndMovement1Component {
  referredToCMOStatus: string = 'N';

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private endMovement1Service: EndMovement1Service
  ) {}

  updateSaveExitAction(status: string): void {
    this.referredToCMOStatus = status;
    const saveExitButton = document.getElementById('saveExitButton');
    if (saveExitButton) {
      saveExitButton.disabled = status === 'N';
    }
  }

  onCancel(): void {
    this.router.navigate(['/insured-person']);
    const saveWindow = document.getElementById('saveWindow');
    if (saveWindow) {
      saveWindow.style.display = 'none';
    }
  }

  openConfirmationDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '400px',
      disableClose: true,
      data: { defaultOption: 'CE' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Handle the result here
      }
    });
  }

  onOkButtonClick(): void {
    const agentCode = 'someAgentCode'; // This should be dynamically set
    const action = 'SE'; // This should be dynamically set

    const isValidAgentCode = this.endMovement1Service.validateAgentCode(agentCode);
    if (!isValidAgentCode) {
      alert('Invalid agent code');
      return;
    }

    if (action === 'SE') {
      this.endMovement1Service.navigateAndValidate(action);
      this.endMovement1Service.insertComments('Some comments');
      this.endMovement1Service.updateProposalStatus('New Status');
    } else if (action === 'CE') {
      this.endMovement1Service.updateUserProfiles({} as UserProfile);
      this.endMovement1Service.deleteComments(123);
    }

    // Suspend work-in-progress logic here

    // Display appropriate messages based on validations
  }

  focusActionItem(): void {
    const actionItem = document.getElementById('actionItem');
    if (actionItem) {
      actionItem.focus();
    }
  }
}
