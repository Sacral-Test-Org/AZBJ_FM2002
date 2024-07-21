import { Component } from '@angular/core';
import { BbprocessService } from 'src/app/services/bbprocess.service';
import { QuestionAnswer } from 'src/app/models/question-answer.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bbprocess',
  templateUrl: './bbprocess.component.html',
  styleUrls: ['./bbprocess.component.css']
})
export class BbprocessComponent {
  selectedPartnerId: string = '';
  questionsAndAnswers: QuestionAnswer[] = [];

  constructor(private bbprocessService: BbprocessService, private router: Router) {}

  onPopulateQuestionsClick(): void {
    if (!this.selectedPartnerId) {
      alert('Please select partner');
      return;
    }
    this.bbprocessService.populateQuestions(this.selectedPartnerId).subscribe(
      (response) => {
        console.log('Questions populated successfully', response);
      },
      (error) => {
        console.error('Error populating questions', error);
      }
    );
  }

  onPartnerSelect(partnerId: string): void {
    this.bbprocessService.fetchQuestionsAndAnswers(partnerId).subscribe(
      (questionsAndAnswers) => {
        this.displayQuestionsAndAnswers(questionsAndAnswers);
      },
      (error) => {
        console.error('Error fetching questions and answers', error);
      }
    );
  }

  displayQuestionsAndAnswers(questionsAndAnswers: QuestionAnswer[]): void {
    this.questionsAndAnswers = questionsAndAnswers;
  }

  onClickViewBBUResults(): void {
    this.router.navigate(['/result']);
    // Assuming we have a service method to check records in Result section
    this.bbprocessService.checkResultRecords().subscribe(
      (hasRecords) => {
        if (!hasRecords) {
          this.router.navigate(['/med-uw']);
        }
      },
      (error) => {
        console.error('Error checking result records', error);
      }
    );
  }

  handleEnterAnswersButtonClick(): void {
    this.bbprocessService.validateAndPopulateAnswers().subscribe(
      (response) => {
        console.log('Answers validated and populated successfully', response);
      },
      (error) => {
        console.error('Error validating and populating answers', error);
      }
    );
  }

  onPopulateQuestionsButtonClick(): void {
    this.bbprocessService.populateQuestions().subscribe(
      (response) => {
        console.log('Questions populated successfully', response);
      },
      (error) => {
        console.error('Error populating questions', error);
      }
    );
  }

  validateQBBUField(value: string): void {
    if (value !== 'Y' && value !== 'N') {
      alert('Kindly enter Y OR N in Answer');
    }
  }
}
