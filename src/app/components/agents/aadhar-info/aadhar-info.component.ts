import { Component, OnInit } from '@angular/core';
import { AgentsService } from 'src/app/services/agents.service';
import { AadharDetails } from 'src/app/models/aadhar-details.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-aadhar-info',
  templateUrl: './aadhar-info.component.html',
  styleUrls: ['./aadhar-info.component.css']
})
export class AadharInfoComponent implements OnInit {
  aadharDetails: AadharDetails;

  constructor(private agentsService: AgentsService) { }

  ngOnInit(): void {
    this.agentsService.getAadharDetails().subscribe(
      (details: AadharDetails) => this.displayAadharDetails(details),
      (error: any) => console.error('Error fetching Aadhar details', error)
    );
  }

  displayAadharDetails(aadharDetails: AadharDetails): void {
    this.aadharDetails = aadharDetails;
    // Logic to display Aadhar details in the UI
  }
}
