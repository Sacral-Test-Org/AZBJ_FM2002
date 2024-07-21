import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyMemberLoadingDetailsService } from 'src/app/services/policy-member-loading-details.service';

@Component({
  selector: 'app-policy-member-loading-details',
  templateUrl: './policy-member-loading-details.component.html',
  styleUrls: ['./policy-member-loading-details.component.css']
})
export class PolicyMemberLoadingDetailsComponent implements OnInit {
  policyMembers: any[] = [];

  constructor(
    private policyMemberLoadingDetailsService: PolicyMemberLoadingDetailsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.policyMemberLoadingDetailsService.getPolicyMembers().subscribe(
      (data: any[]) => {
        this.policyMembers = data;
      },
      (error) => {
        console.error('Error fetching policy member loading details', error);
      }
    );
  }

  onBackButtonClick(): void {
    this.router.navigate(['/previous-screen']);
  }
}
