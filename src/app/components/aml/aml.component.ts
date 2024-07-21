import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AmlService } from '../../services/aml.service';
import { ProofType, ProofDescription, ValidationResponse } from '../../models/aml.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-aml',
  templateUrl: './aml.component.html',
  styleUrls: ['./aml.component.css']
})
export class AmlComponent implements OnInit {
  amlForm: FormGroup;
  proofTypes: ProofType[] = [];
  proofDescriptions: ProofDescription[] = [];
  isEditAmlDetails: boolean = false;
  message: string = '';

  constructor(
    private fb: FormBuilder,
    private amlService: AmlService,
    private logger: NGXLogger
  ) {
    this.amlForm = this.fb.group({
      documentDescription: [''],
      documentType: [''],
      mandatoryFlag: [false],
      value: [{ value: '', disabled: true }],
      proofType: [''],
      documentId: [{ value: '', disabled: true }],
      expiryDate: [''],
      oldPolicyReference: [''],
      proofDescription: [''],
      documentRemarks: ['']
    });
  }

  ngOnInit(): void {
    this.fetchProofTypes();
    this.fetchProofDescriptions();
  }

  fetchProofTypes(): void {
    this.amlService.fetchProofTypes().subscribe(
      (data: ProofType[]) => {
        this.proofTypes = data;
      },
      (error) => {
        this.logger.error('Error fetching proof types', error);
      }
    );
  }

  fetchProofDescriptions(): void {
    this.amlService.fetchProofDescriptions().subscribe(
      (data: ProofDescription[]) => {
        this.proofDescriptions = data;
      },
      (error) => {
        this.logger.error('Error fetching proof descriptions', error);
      }
    );
  }

  populateAmlDetails(): void {
    this.amlService.populateAmlDetails().subscribe(
      (data) => {
        this.message = 'AML details populated successfully';
        this.logger.info(this.message);
      },
      (error) => {
        this.message = 'Error populating AML details';
        this.logger.error(this.message, error);
      }
    );
  }

  toggleEditAmlDetails(): void {
    this.isEditAmlDetails = !this.isEditAmlDetails;
    if (this.isEditAmlDetails) {
      this.amlForm.get('value')?.enable();
      this.amlForm.get('documentId')?.enable();
    } else {
      this.amlForm.get('value')?.disable();
      this.amlForm.get('documentId')?.disable();
    }
  }

  onDocumentRemarksBlur(): void {
    // Logic to move focus to BI Number field in Agents section
    const biNumberField = document.getElementById('biNumber');
    if (biNumberField) {
      biNumberField.focus();
    }
  }

  checkEditability(documentType: string, chkEditAml: string): void {
    const nonEditableTypes = [
      'LEGAL_NAME', 'PERMANENT_ADDRESS', 'CURRENT_ADDRESS', 'SOURCE_OF_FUNDS3',
      'COMPANY_NAME', 'COMPANY_ADDRESS', 'PARTNERSHIP_FIRM_NAME',
      'PARTNERSHIP_FIRM_ADDRESS', 'TRUSTEES_NAME', 'TRUSTEES_ADDRESSES'
    ];
    if (nonEditableTypes.includes(documentType) || chkEditAml !== 'Y') {
      this.amlForm.get('value')?.disable();
    } else {
      this.amlForm.get('value')?.enable();
    }
  }

  onPopulateAmlDetails(): void {
    this.populateAmlDetails();
  }

  enableDisableDocumentIdField(): void {
    this.amlService.getChkEditAmlStatus().subscribe(
      (status: string) => {
        if (status === 'Y') {
          this.amlForm.get('documentId')?.enable();
        } else {
          this.amlForm.get('documentId')?.disable();
        }
      },
      (error) => {
        this.logger.error('Error fetching CHK_EDIT_AML status', error);
      }
    );
  }

  validateDocumentId(documentId: string): ValidationResponse {
    const panCardPattern = /^[A-Z]{3}[C,P,H,F,A,T,B,L,J,G][A-Z][0-9]{4}[A-Z]$/;
    if (documentId.length !== 10 || !panCardPattern.test(documentId)) {
      this.message = 'Invalid Document ID';
      this.logger.error(this.message);
      return { isValid: false, message: this.message };
    }
    this.message = 'Document ID is valid';
    this.logger.info(this.message);
    return { isValid: true, message: this.message };
  }
}
