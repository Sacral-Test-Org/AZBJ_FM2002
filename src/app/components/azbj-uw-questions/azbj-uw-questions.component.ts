import { Component, OnInit } from '@angular/core';
import { AzbjUwQuestionsService } from '../../services/azbj-uw-questions.service';
import { Question } from '../../models/question.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-azbj-uw-questions',
  templateUrl: './azbj-uw-questions.component.html',
  styleUrls: ['./azbj-uw-questions.component.css']
})
export class AzbjUwQuestionsComponent implements OnInit {
  questions: Question[] = [];
  displayedQuestions: Question[] = [];
  pageSize: number = 10;
  currentPage: number = 0;

  constructor(private questionsService: AzbjUwQuestionsService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.loadQuestions();
  }

  loadQuestions(): void {
    this.questionsService.getQuestions().subscribe(
      (data: Question[]) => {
        this.questions = data;
        this.updateDisplayedQuestions();
      },
      (error) => {
        this.logger.error('Error loading questions', error);
      }
    );
  }

  updateDisplayedQuestions(): void {
    const start = this.currentPage * this.pageSize;
    const end = start + this.pageSize;
    this.displayedQuestions = this.questions.slice(start, end);
  }

  nextPage(): void {
    if ((this.currentPage + 1) * this.pageSize < this.questions.length) {
      this.currentPage++;
      this.updateDisplayedQuestions();
    }
  }

  previousPage(): void {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.updateDisplayedQuestions();
    }
  }

  onQuestionChange(question: Question): void {
    const index = this.questions.findIndex(q => q.id === question.id);
    if (index !== -1) {
      this.questions[index] = question;
    }
  }

  onCheckboxChange(question: Question, isChecked: boolean): void {
    const index = this.questions.findIndex(q => q.id === question.id);
    if (index !== -1) {
      this.questions[index].selected = isChecked;
    }
  }
}
