import { Component, OnInit } from '@angular/core';
import { BbprocessService } from 'src/app/services/bbprocess.service';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {
  questionNumber: string = '';
  formQuestionNumber1: string = '';
  description: string = '';

  constructor(private bbprocessService: BbprocessService) { }

  ngOnInit(): void {
    // Initialize the component and set up any necessary properties.
  }

  navigateToPreviousRecordIfQuestionNumberEmpty(): void {
    if (!this.questionNumber) {
      this.navigateToPreviousRecord();
    }
  }

  onKeyDown(event: KeyboardEvent): void {
    if (event.key === 'ArrowDown') {
      event.preventDefault();
    }
  }

  checkFormQuestionNumber(): void {
    if (!this.formQuestionNumber1) {
      this.navigateToPreviousRecord();
    }
  }

  navigateToPreviousRecord(): void {
    // Logic to navigate to the previous record.
  }

  populateDescriptionBlock(): void {
    this.bbprocessService.getPopulatedDescription().subscribe(data => {
      // Logic to populate the description block based on the questionnaire answers.
    });
  }
}
