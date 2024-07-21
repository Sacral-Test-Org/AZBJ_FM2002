import { Component, OnInit } from '@angular/core';
import { PrevDetService } from 'src/app/services/prev-det.service';
import { Decision } from 'src/app/models/decision.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-prev-det',
  templateUrl: './prev-det.component.html',
  styleUrls: ['./prev-det.component.css']
})
export class PrevDetComponent implements OnInit {
  decisions: Decision[] = [];
  selectedDecision: Decision | null = null;

  constructor(private prevDetService: PrevDetService) {}

  ngOnInit(): void {
    this.prevDetService.getPreviousDecisions().subscribe((data: Decision[]) => {
      this.decisions = data;
    });
  }

  onDecisionSelect(decision: Decision): void {
    this.selectedDecision = decision;
  }
}