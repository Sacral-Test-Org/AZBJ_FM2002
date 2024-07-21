import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IncompleteProposalDetailsService } from 'src/app/services/incomplete-proposal-details.service';

@Component({
  selector: 'app-incomplete-proposal-details',
  templateUrl: './incomplete-proposal-details.component.html',
  styleUrls: ['./incomplete-proposal-details.component.css']
})
export class IncompleteProposalDetailsComponent implements OnInit {
  proposalFormFields: string[] = [];
  comments: string = '';
  detailsReceived: string = 'No';
  selectedRows: any[] = [];

  constructor(
    private router: Router,
    private incompleteProposalDetailsService: IncompleteProposalDetailsService
  ) {}

  ngOnInit(): void {
    this.loadProposalFormFields();
  }

  loadProposalFormFields(): void {
    this.incompleteProposalDetailsService.getProposalFormFields().subscribe(
      (data: string[]) => {
        this.proposalFormFields = data;
      },
      (error) => {
        console.error('Error loading proposal form fields', error);
      }
    );
  }

  onDetailsReceivedChange(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.detailsReceived = target.value;
  }

  onSaveClick(): void {
    if (confirm('Do you really want to Save Incomplete Proposal Form Details?')) {
      this.incompleteProposalDetailsService.saveIncompleteProposalDetails({
        comments: this.comments,
        detailsReceived: this.detailsReceived,
        selectedRows: this.selectedRows
      }).subscribe(
        () => {
          alert('Incomplete Proposal Form Details saved successfully.');
        },
        (error) => {
          console.error('Error saving incomplete proposal details', error);
        }
      );
    }
  }

  onAddRowClick(): void {
    if (confirm('Do you want to add a new record?')) {
      this.selectedRows.push({
        comments: '',
        detailsReceived: 'No'
      });
    }
  }

  deleteSelectedRecords(): void {
    this.selectedRows = this.selectedRows.filter(row => !row.selected);
  }

  onBackButtonClick(): void {
    this.router.navigate(['/further-requirements']);
  }
}