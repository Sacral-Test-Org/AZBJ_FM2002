import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AgentsService } from 'src/app/services/agents.service';
import { DuplicateContactNoService } from 'src/app/services/duplicate-contact-no.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-duplicate-contact-no',
  templateUrl: './duplicate-contact-no.component.html',
  styleUrls: ['./duplicate-contact-no.component.css']
})
export class DuplicateContactNoComponent implements OnInit {
  duplicateContacts: any[] = [];
  contactNumber: string = '';

  constructor(
    private agentsService: AgentsService,
    private duplicateContactNoService: DuplicateContactNoService,
    private router: Router,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.checkDuplicateContactNo();
  }

  checkDuplicateContactNo(): void {
    this.agentsService.checkDuplicateContactNo(this.contactNumber).subscribe(
      (isDuplicate: boolean) => {
        if (isDuplicate) {
          this.logger.info('Duplicate contact number found.');
          this.router.navigate(['/duplicate-contact-no']);
          this.getDuplicateContacts();
        } else {
          this.logger.info('No duplicate contact number found.');
          alert('No duplicate contact number found.');
        }
      },
      (error) => {
        this.logger.error('Error checking duplicate contact number:', error);
      }
    );
  }

  getDuplicateContacts(): void {
    this.duplicateContactNoService.getDuplicateContacts().subscribe(
      (data: any[]) => {
        this.duplicateContacts = data;
      },
      (error) => {
        this.logger.error('Error fetching duplicate contacts:', error);
      }
    );
  }

  markForReview(record: any): void {
    record.CHKSUP = !record.CHKSUP;
  }
}
