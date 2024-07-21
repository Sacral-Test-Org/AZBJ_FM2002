import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SimultaneousProposalsService } from 'src/app/services/simultaneous-proposals.service';
import { Proposal } from 'src/app/models/proposal.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-simultaneous-proposals',
  templateUrl: './simultaneous-proposals.component.html',
  styleUrls: ['./simultaneous-proposals.component.css']
})
export class SimultaneousProposalsComponent implements OnInit {
  proposals: Proposal[] = [];
  ipNumbers: string[] = [];

  constructor(
    private proposalsService: SimultaneousProposalsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchProposals();
    this.getIPNumbers();
  }

  fetchProposals(): void {
    this.proposalsService.fetchProposals().subscribe((data: Proposal[]) => {
      this.proposals = data;
    });
  }

  getIPNumbers(): void {
    this.proposalsService.getIPNumbers().subscribe((data: string[]) => {
      this.ipNumbers = data;
    });
  }

  exitForm(): void {
    this.router.navigate(['/med_uw']);
  }
}
