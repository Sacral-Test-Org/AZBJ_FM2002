import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FakeDocumentService } from 'src/app/services/fake-document.service';
import { Observable } from 'rxjs';
import { LovData, ProofType, FakeDocumentDTO } from 'src/app/models/fake-document.model';

@Component({
  selector: 'app-fake-document',
  templateUrl: './fake-document.component.html',
  styleUrls: ['./fake-document.component.css']
})
export class FakeDocumentComponent implements OnInit {
  fakeDocument: FakeDocumentDTO = new FakeDocumentDTO();
  commentsList: string[] = [];
  categoryList: string[] = [];
  proofTypes: ProofType[] = [];

  constructor(private fakeDocumentService: FakeDocumentService, private router: Router) {}

  ngOnInit(): void {
    this.initializeDefaultValues();
  }

  initializeDefaultValues(): void {
    this.fakeDocument.isFake = false;
    this.fakeDocument.issuanceNotAllowed = false;
  }

  manageFakeDocument(): void {
    if (this.fakeDocument.id) {
      this.fakeDocumentService.updateFakeDocument(this.fakeDocument).subscribe();
    } else {
      this.fakeDocumentService.saveFakeDocument(this.fakeDocument).subscribe();
    }
  }

  exitButtonHandler(): void {
    this.router.navigate(['/main-document-management']);
  }

  checkIssuanceNotAllowed(): void {
    if (!this.fakeDocument.isFake) {
      this.fakeDocument.issuanceNotAllowed = false;
      alert('Please untick the check box as Fake document not marked.');
    }
  }

  updateFakeDocument(): void {
    if (this.fakeDocument.isFake && (!this.fakeDocument.comments || !this.fakeDocument.category)) {
      alert('Comments and Category fields are required for fake documents.');
      return;
    }
    if (confirm('Do you wish to continue generating a report for the fake document?')) {
      this.fakeDocumentService.updateFakeDocument(this.fakeDocument).subscribe(() => {
        this.router.navigate(['/med-uw']);
      });
    }
  }

  toggleCommentsEditability(): void {
    if (this.fakeDocument.isFake) {
      // Enable comments field
    } else {
      // Disable comments field
    }
  }

  onCommentsDoubleClick(): void {
    this.fakeDocumentService.fetchCommentsList().subscribe((data: any[]) => {
      this.commentsList = data.map(item => item.SYS_DESC);
    });
  }

  onFakeDocumentChange(event: Event): void {
    this.fakeDocumentService.fetchCategoryValues().subscribe((data: any[]) => {
      this.categoryList = data.map(item => item.SYS_DESC);
    });
    this.toggleOtherField();
  }

  onCategoryDoubleClick(event: Event): void {
    this.fakeDocumentService.fetchCategoryValues().subscribe((data: any[]) => {
      this.categoryList = data.map(item => item.SYS_DESC);
    });
  }

  updateFieldEditability(fakeDocumentValue: string): void {
    if (fakeDocumentValue === 'Y') {
      // Enable Document Proof Type and Fake Mark fields
    } else {
      // Disable Document Proof Type and Fake Mark fields
    }
  }

  fetchLovData(documentCode: string, fakeDocumentValue: string): Observable<LovData[]> {
    return this.fakeDocumentService.getLovData(documentCode, fakeDocumentValue);
  }

  handleSave(): void {
    if (this.fakeDocument.isFake && (!this.fakeDocument.comments || !this.fakeDocument.category)) {
      alert('Comments and Category fields are required for fake documents.');
      return;
    }
    if (confirm('Do you wish to continue generating a report for the fake document?')) {
      this.fakeDocumentService.saveFakeDocument(this.fakeDocument).subscribe(() => {
        // Disable save button
      });
    } else {
      alert('No fake document is mentioned.');
    }
  }

  handleFakeDocumentChange(): void {
    if (this.fakeDocument.isFake) {
      switch (this.fakeDocument.docCode) {
        case 'M02':
          this.getProofTypes('COMPANY_ADDRESS');
          break;
        case 'M03':
          this.getProofTypes('SOURCE_OF_FUNDS1');
          break;
        case 'M04':
          this.getProofTypes('COMPANY_NAME');
          break;
        case 'M01':
          this.getProofTypes('AGE_PROOF');
          break;
        default:
          // Disable Fake Mark field
          break;
      }
    } else {
      // Disable Fake Mark field
    }
  }

  getProofTypes(documentType: string): void {
    this.fakeDocumentService.getProofTypes(documentType).subscribe((data: ProofType[]) => {
      this.proofTypes = data;
    });
  }

  toggleOtherField(): void {
    if (this.fakeDocument.isFake) {
      // Enable Other field
    } else {
      // Disable Other field
    }
  }
}
