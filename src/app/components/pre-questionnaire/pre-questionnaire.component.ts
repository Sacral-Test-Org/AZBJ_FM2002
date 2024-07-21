import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pre-questionnaire',
  templateUrl: './pre-questionnaire.component.html',
  styleUrls: ['./pre-questionnaire.component.css']
})
export class PreQuestionnaireComponent implements OnInit {
  preQuestionnaire: string = 'PRE QUESTIONNAIRE';
  preReqNo: string = 'PRE REQ NO';
  preProposalNo: string = 'PRE PROPOSAL NO';

  constructor() { }

  ngOnInit(): void {
    // Fields are already initialized in uppercase and are read-only by default
  }
}
