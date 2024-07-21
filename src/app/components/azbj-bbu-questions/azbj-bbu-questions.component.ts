import { Component, OnInit } from '@angular/core';
import { QuestionnaireService } from 'src/app/services/questionnaire.service';
import { Questionnaire } from 'src/app/models/questionnaire.model';
import { ValidationErrorComponent } from './validation-error/validation-error.component';
import { AzbjBbuQuestionsService } from 'src/app/services/azbj-bbu-questions.service';
import { CloseButtonComponent } from './close-button/close-button.component';

@Component({
  selector: 'app-azbj-bbu-questions',
  templateUrl: './azbj-bbu-questions.component.html',
  styleUrls: ['./azbj-bbu-questions.component.css']
})
export class AzbjBbuQuestionsComponent implements OnInit {
  questions: Questionnaire[] = [];
  currentIndex: number = 0;

  constructor(
    private questionnaireService: QuestionnaireService,
    private azbjBbuQuestionsService: AzbjBbuQuestionsService,
    private validationErrorComponent: ValidationErrorComponent,
    private closeButtonComponent: CloseButtonComponent
  ) {}

  ngOnInit(): void {
    this.fetchQuestionnaireDetails();
  }

  fetchQuestionnaireDetails(): void {
    this.questionnaireService.getQuestionnaireDetails().subscribe((data: Questionnaire[]) => {
      this.questions = data;
    });
  }

  navigateRecords(event: KeyboardEvent): void {
    if (event.key === 'ArrowDown') {
      this.currentIndex = Math.min(this.currentIndex + 1, this.questions.length - 1);
    } else if (event.key === 'ArrowUp') {
      this.currentIndex = Math.max(this.currentIndex - 1, 0);
    }
    const currentQuestion = this.questions[this.currentIndex];
    if (!currentQuestion.formQuestionNumber && !currentQuestion.questionDescription && this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

  validateDescriptionInput(answer: string, questionId: number, subQuestionId: number, description: string): void {
    if (answer !== 'Y' && questionId !== 85 && (subQuestionId === 68 || subQuestionId === 69) && description) {
      this.validationErrorComponent.showError('Answer to the question is N. Hence cannot enter description.');
    }
  }

  handleKeyDown(): void {
    this.currentIndex = Math.min(this.currentIndex + 1, this.questions.length - 1);
  }

  handleKeyUp(): void {
    this.currentIndex = Math.max(this.currentIndex - 1, 0);
  }

  handleNewRecord(): void {
    const currentQuestion = this.questions[this.currentIndex];
    if (!currentQuestion.formQuestionNumber && !currentQuestion.questionDescription && this.currentIndex > 0) {
      this.currentIndex--;
    }
  }

  validateAndProcessAnswers(answers: any[]): void {
    if (this.azbjBbuQuestionsService.validateAnswers(answers)) {
      this.azbjBbuQuestionsService.processAnswers(answers);
    }
  }

  validateAnswer(questionId: number, answer: string): void {
    const validationResponse = this.azbjBbuQuestionsService.validateAnswer(questionId, answer);
    if (!validationResponse.isValid) {
      this.validationErrorComponent.showError(validationResponse.errorMessage);
    }
  }

  handleCloseButtonClick(): void {
    this.closeButtonComponent.closeButtonClickHandler();
  }

  updateBusinessUnit(businessUnit: any): void {
    this.azbjBbuQuestionsService.updateBusinessUnit(businessUnit).subscribe();
  }

  createRecord(record: any): void {
    this.azbjBbuQuestionsService.createImageDetail(record).subscribe();
  }

  readRecord(id: number): void {
    this.azbjBbuQuestionsService.readImageDetail(id).subscribe();
  }

  updateRecord(record: any): void {
    this.azbjBbuQuestionsService.updateImageDetail(record).subscribe();
  }

  deleteRecord(id: number): void {
    this.azbjBbuQuestionsService.deleteImageDetail(id).subscribe();
  }

  handleFunctionKeys(event: KeyboardEvent): void {
    if (event.key === 'F0') {
      // Handle F0 key action
    } else if (event.key === 'F1') {
      // Handle F1 key action
    }
  }
}
