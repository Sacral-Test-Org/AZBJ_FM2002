import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ControlService } from 'src/app/services/control.service';

@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent {
  constructor(private router: Router, private controlService: ControlService) {}

  onExitButtonClick(): Promise<boolean> {
    return this.router.navigate(['/comments']).then(success => {
      if (success) {
        // Logic to highlight or focus the comments section
        const commentsSection = document.getElementById('comments-section');
        if (commentsSection) {
          commentsSection.scrollIntoView();
          commentsSection.focus();
        }
      }
      return success;
    });
  }

  clearButtonHandler(): void {
    this.navigateToCFT();
    this.resetCFTData();
  }

  navigateToCFT(): void {
    this.router.navigate(['/cft']);
  }

  resetCFTData(): void {
    this.controlService.resetCFTData();
  }

  onPopulateQuestionButtonClick(): void {
    this.enableQuestionFields();
    this.clearQuestionsBlock();
    this.controlService.fetchQuestions().subscribe(
      questions => {
        this.populateQuestionsBlock(questions);
        this.setCheckFlags(questions);
        this.disableQuestionFields();
      },
      error => {
        this.displayErrorMessage('Error fetching questions');
      }
    );
  }

  enableQuestionFields(): void {
    // Logic to enable question description and question ID fields
  }

  clearQuestionsBlock(): void {
    // Logic to clear existing data in the questions block
  }

  populateQuestionsBlock(questions: any[]): void {
    // Logic to populate the questions block with fetched data
  }

  setCheckFlags(questions: any[]): void {
    // Logic to set the check flag to 'Y' for question IDs '1', '2', '3', or '4'
  }

  disableQuestionFields(): void {
    // Logic to disable question description and question ID fields
  }

  displayErrorMessage(message: string): void {
    // Logic to display error message
  }

  saveResponses(): void {
    if (!this.validateQuestions()) {
      this.displayErrorMessage('Please answer all required questions');
      return;
    }
    const policyRef = 'somePolicyRef'; // Replace with actual policy reference
    const contractId = 'someContractId'; // Replace with actual contract ID
    const questions = []; // Replace with actual questions array
    this.controlService.saveResponsesToDB(policyRef, contractId, questions).subscribe(
      response => {
        this.displaySuccessMessage('Responses saved successfully');
      },
      error => {
        this.displayErrorMessage('Error saving responses');
      }
    );
  }

  validateQuestions(): boolean {
    // Logic to validate that specific questions (IDs 1, 2, 3, 4) are answered
    return true;
  }

  displaySuccessMessage(message: string): void {
    // Logic to display success message
  }

  handleRelationWithStaff(relationWithStaff: string): void {
    this.controlService.saveRelationWithStaff(relationWithStaff).subscribe(
      response => {
        this.displaySuccessMessage('Relation with staff saved successfully');
      },
      error => {
        this.displayErrorMessage('Error saving relation with staff');
      }
    );
  }

  crmCommentsButtonHandler(): void {
    const contractId = 'someContractId'; // Replace with actual contract ID
    this.controlService.getCRMComments(contractId).subscribe(
      comments => {
        this.populateCRMCommentsSection(comments);
        this.disableCRMCommentsFields();
      },
      error => {
        this.displayErrorMessage('Error fetching CRM comments');
      }
    );
  }

  populateCRMCommentsSection(comments: any[]): void {
    // Logic to populate the CRM comments section with the retrieved data
  }

  disableCRMCommentsFields(): void {
    // Logic to disable the insertion and updating of CRM comments
  }

  onExit(): void {
    this.moveFocusToBenOwner();
    this.hideCurrentView();
    this.hideBeneficialOwnershipWindow();
    this.displayMainTabView();
  }

  moveFocusToBenOwner(): void {
    // Logic to move the focus to the 