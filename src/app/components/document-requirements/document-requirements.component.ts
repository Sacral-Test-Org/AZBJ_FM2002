import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-document-requirements',
  templateUrl: './document-requirements.component.html',
  styleUrls: ['./document-requirements.component.css']
})
export class DocumentRequirementsComponent implements OnInit {
  requirementType: string;
  requirementDescription: string;

  constructor(private http: HttpClient, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.fetchDocumentRequirements();
  }

  fetchDocumentRequirements(): void {
    // Simulate fetching data from an API
    this.requirementType = 'Type A';
    this.requirementDescription = 'Description of Type A requirement';
    this.logger.info('Document requirements fetched successfully');
  }

  closeSection(): void {
    // Logic to close the document requirements section
    this.logger.info('Document requirements section closed');
  }

  viewReasons(): void {
    // Logic to display reasons related to the document requirements
    this.logger.info('Displaying reasons for document requirements');
    alert('Reasons for document requirements: Reason 1, Reason 2, Reason 3');
  }
}
