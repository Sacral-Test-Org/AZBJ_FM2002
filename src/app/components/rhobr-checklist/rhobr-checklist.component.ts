import { Component, OnInit } from '@angular/core';
import { RhobrChecklistService } from 'src/app/services/rhobr-checklist.service';
import { HorizontalToolbarComponent } from 'src/app/components/horizontal-toolbar/horizontal-toolbar.component';
import { CoverheadComponent } from 'src/app/components/coverhead/coverhead.component';

@Component({
  selector: 'app-rhobr-checklist',
  templateUrl: './rhobr-checklist.component.html',
  styleUrls: ['./rhobr-checklist.component.css']
})
export class RhobrChecklistComponent implements OnInit {
  checklist: any[] = [];
  rhobrUserId: string = '';
  isChangeStatusButtonVisible: boolean = false;

  constructor(private rhobrChecklistService: RhobrChecklistService) {}

  ngOnInit(): void {
    this.rhobrChecklistService.getChecklist().subscribe(data => {
      this.checklist = data;
    });
  }

  exit(): void {
    const horizontalToolbar = new HorizontalToolbarComponent();
    if (horizontalToolbar.isCommitFormButtonDisabled()) {
      horizontalToolbar.enableCommitFormButton();
    }
    const coverhead = new CoverheadComponent();
    coverhead.navigateToValidButt();
    // Logic to hide the current RHOBR checklist window
  }

  changeStatusToRhobr(): void {
    this.rhobrChecklistService.updateStatusToRHOBR().subscribe(() => {
      // Logic to handle successful status update
    });
  }

  onCheckboxChange(requirement: any): void {
    requirement.dateTicked = new Date();
    requirement.userTicked = 'currentUser'; // Replace with actual user
  }

  handleChangeStatusClick(): void {
    this.changeStatusToRhobr();
  }

  onExitButtonClick(): void {
    this.exit();
  }
}