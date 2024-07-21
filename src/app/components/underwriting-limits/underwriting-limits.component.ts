import { Component, OnInit } from '@angular/core';
import { UnderwritingLimitsService } from 'src/app/services/underwriting-limits.service';
import { UnderwritingLimit } from 'src/app/models/underwriting-limit.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-underwriting-limits',
  templateUrl: './underwriting-limits.component.html',
  styleUrls: ['./underwriting-limits.component.css']
})
export class UnderwritingLimitsComponent implements OnInit {
  underwritingLimits: UnderwritingLimit[] = [];

  constructor(
    private underwritingLimitsService: UnderwritingLimitsService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.getUnderwritingLimits();
  }

  getUnderwritingLimits(): void {
    this.underwritingLimitsService.getUnderwritingLimits().subscribe(
      (data: UnderwritingLimit[]) => {
        this.underwritingLimits = data;
        this.logger.info('Underwriting limits retrieved successfully');
      },
      (error) => {
        this.logger.error('Error retrieving underwriting limits', error);
      }
    );
  }

  exit(): void {
    // Logic to close the view, e.g., navigate to another route or close a modal
    this.logger.info('Exit button clicked');
  }
}
