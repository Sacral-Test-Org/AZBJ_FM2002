import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApprovalDetailsService } from '../../services/approval-details.service';
import { ApprovalDetails } from '../../models/approval-details.model';

@Component({
  selector: 'app-approval-details',
  templateUrl: './approval-details.component.html',
  styleUrls: ['./approval-details.component.css']
})
export class ApprovalDetailsComponent implements OnInit {
  approvalId: string;
  approvalName: string;
  approvalDate: string;
  approvalTime: string;
  approvalDecision: string;

  constructor(private approvalDetailsService: ApprovalDetailsService, private router: Router) {}

  ngOnInit(): void {
    this.approvalDetailsService.getApprovalDetails().subscribe((details: ApprovalDetails) => {
      this.approvalId = details.approvalId;
      this.approvalName = details.approvalName;
      this.approvalDate = new Date(details.approvalDate).toLocaleDateString();
      this.approvalTime = new Date(details.approvalTime).toLocaleTimeString();
      this.approvalDecision = details.approvalDecision;
    });
  }

  exit(): void {
    this.router.navigate(['/new-business']);
  }

  exitButtonHandler(): void {
    this.exit();
  }
}
