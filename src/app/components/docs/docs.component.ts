import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DocsService } from 'src/app/services/docs.service';
import { RejectedApplicationReasonDTO } from 'src/app/models/rejected-application-reason-dto.model';

@Component({
  selector: 'app-docs',
  templateUrl: './docs.component.html',
  styleUrls: ['./docs.component.css']
})
export class DocsComponent {
  reasons: RejectedApplicationReasonDTO[] = [];

  constructor(private router: Router, private docsService: DocsService) {}

  closeButtonHandler(): void {
    // Navigate to 'further_req.rcu'
    this.router.navigate(['/further_req.rcu']);
    // Hide the current 'docs' window
    const docsWindow = document.getElementById('docs');
    if (docsWindow) {
      docsWindow.style.display = 'none';
    }
  }

  onReasonButtonClick(): void {
    const applicationNo = 'someApplicationNo'; // Replace with actual logic to get application number
    const alternateReq = 'someAlternateReq'; // Replace with actual logic to get alternate request type
    this.docsService.getRejectedApplicationReasons(applicationNo, alternateReq).subscribe(
      (reasons: RejectedApplicationReasonDTO[]) => {
        this.reasons = reasons;
      },
      (error) => {
        console.error('Error fetching reasons:', error);
      }
    );
  }
}
