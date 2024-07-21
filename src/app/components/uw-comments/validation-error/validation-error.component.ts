import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-validation-error',
  templateUrl: './validation-error.component.html',
  styleUrls: ['./validation-error.component.css']
})
export class ValidationErrorComponent implements OnInit {
  underwritingComments: string = '';

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.fetchUnderwritingComments();
  }

  fetchUnderwritingComments(): void {
    const applNo = '1100298672'; // Example application number
    const url = `/api/underwriting-comments/${applNo}`;

    this.http.get(url).subscribe(
      (response: any) => {
        this.processUnderwritingComments(response);
      },
      (error) => {
        this.logger.error('Error fetching underwriting comments', error);
        this.underwritingComments = 'Error fetching underwriting comments';
      }
    );
  }

  processUnderwritingComments(data: any): void {
    try {
      const { param_type, rule_message, trans_id } = data;

      if (param_type === 'QC REQUIREMENTS' && rule_message !== 'QC Requirements raised.') {
        this.fetchQuestionDescription(trans_id, rule_message);
      } else {
        this.underwritingComments = rule_message;
      }
    } catch (error) {
      this.logger.error('Error processing underwriting comments', error);
      this.underwritingComments = 'Error processing underwriting comments';
    }
  }

  fetchQuestionDescription(transId: string, ruleMessage: string): void {
    const url = `/api/question-description/${transId}/${ruleMessage}`;

    this.http.get(url).subscribe(
      (response: any) => {
        this.underwritingComments = response.question_desc;
      },
      (error) => {
        this.logger.error('Error fetching question description', error);
        this.underwritingComments = 'Error fetching question description';
      }
    );
  }
}
