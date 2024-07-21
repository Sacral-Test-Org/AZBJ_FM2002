import { Component, OnInit } from '@angular/core';
import { PreviousPolicyWindowService } from 'src/app/services/previous-policy-window.service';
import { PreviousDecision } from 'src/app/models/previous-decision.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-previous-policy-window',
  templateUrl: './previous-policy-window.component.html',
  styleUrls: ['./previous-policy-window.component.css']
})
export class PreviousPolicyWindowComponent implements OnInit {
  previousDecisions: PreviousDecision[] = [];

  constructor(private previousPolicyWindowService: PreviousPolicyWindowService) { }

  ngOnInit(): void {
    this.fetchPreviousDecisions();
  }

  fetchPreviousDecisions(): void {
    this.previousPolicyWindowService.fetchPreviousDecisions().subscribe(
      (data: PreviousDecision[]) => {
        this.previousDecisions = data;
      },
      (error) => {
        console.error('Error fetching previous decisions', error);
      }
    );
  }
}
