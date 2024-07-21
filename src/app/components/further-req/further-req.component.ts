import { Component, OnInit } from '@angular/core';
import { FurtherReqService } from 'src/app/services/further-req.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-further-req',
  templateUrl: './further-req.component.html',
  styleUrls: ['./further-req.component.css']
})
export class FurtherReqComponent implements OnInit {
  constructor(private furtherReqService: FurtherReqService) {}

  ngOnInit(): void {
    this.fetchFrequentRequirements();
  }

  handleButtonPress(): void {
    const requestType = 'FR'; // Example request type
    const testNumber = '123'; // Example test number
    const description = 'Test Description'; // Example description
    const dateCalled = new Date().toISOString(); // Example date called

    if (requestType !== 'MED') {
      this.furtherReqService.processRequest(requestType, testNumber, description, dateCalled).subscribe(response => {
        // Handle response
      });
    }
  }

  onSaveButtonClick(): void {
    const formData = {}; // Example form data
    if (this.validateFormData(formData)) {
      this.furtherReqService.saveFormData(formData).subscribe(response => {
        this.furtherReqService.checkFieldStatus('FURTHER_REQ.SECND_FRAR_REQ').subscribe(isEnabled => {
          if (isEnabled) {
            this.navigateToSecndFrarReq();
          } else {
            this.navigateToRcu();
          }
        });
      });
    }
  }

  handleExitClick(): void {
    this.furtherReqService.isSecndFrarReqEnabled().subscribe(isEnabled => {
      if (isEnabled) {
        this.navigateToSecndFrarReq();
      } else {
        this.navigateToRcu();
      }
    });
  }

  addRequirement(): void {
    const newRequirement = {}; // Example new requirement
    this.furtherReqService.addRequirement(newRequirement).subscribe(response => {
      // Handle response
    });
  }

  deleteRequirement(requirementId: number): void {
    this.furtherReqService.deleteRequirement(requirementId).subscribe(response => {
      // Handle response
    });
  }

  updateRequirement(requirementId: number, updatedDetails: any): void {
    this.furtherReqService.updateRequirement(requirementId, updatedDetails).subscribe(response => {
      // Handle response
    });
  }

  validateRequirementNumber(requirementNumber: string): Observable<boolean> {
    return this.furtherReqService.validateRequirementNumber(requirementNumber);
  }

  fetchFrequentRequirements(): void {
    this.furtherReqService.fetchFrequentRequirements().subscribe(requirements => {
      // Handle requirements
    });
  }

  validateRequestNumber(requestNumber: string): boolean {
    // Implement validation logic
    return true;
  }

  handleNavigation(direction: string): void {
    // Implement navigation logic
  }

  setTypeField(equalInsuranceStatus: number): void {
    if (equalInsuranceStatus === 1) {
      // Set the Type field to 1
    }
  }

  navigateToReqNoField(): void {
    this.populateDates();
    this.displayReqNoLOV();
  }

  populateDates(): void {
    this.furtherReqService.fetchCurrentDate().subscribe(currentDate => {
      // Populate current date
    });
    this.furtherReqService.fetchExternalDate().subscribe(externalDate => {
      // Populate external date
    });
  }

  displayReqNoLOV(): void {
    this.furtherReqService.fetchReqNoData().subscribe(data => {
      // Display LOV data
    });
  }

  validateRemarks(remarks: string): void {
    if (remarks && remarks.length < 10) {
      this.displayErrorMessage('Comments should not be less than 10 characters.');
    }
  }

  displayErrorMessage(message: string): void {
    // Display error message
  }

  onSecondFrarReqButtonClick(): void {
    this.furtherReqService.checkAndPopulateFrarDetails().subscribe(response => {
      // Handle response
    });
  }

  fetchLOVData(): void {
    this.furtherReqService.fetchLOVData().subscribe(data => {
      // Handle LOV data
    });
  }

  onPopulateTop20Reqs(): void {
    this.furtherReqService.getTop20FrequentRequirements().subscribe(requirements => {
      // Populate requirements
    });
  }

  onRcuRequirementsButtonClick(): void {
    const applicationNo = '12345'; // Example application number
    this.furtherReqService.fetchRcuRequirements(applicationNo).subscribe(response => {
      // Handle response
    });
  }

  setIpTypeAndValidate(productId: number, isSamePerson: boolean): void {
    this.furtherReqService.validateIpType(productId, isSamePerson);
  }

  onClickFurtherReqField(): void {
    this.navigateToField('furtherReqField');
  }

  onAccessFurtherReqField(): void {
    this.furtherReqService.getCurrentDate().subscribe(currentDate => {
      // Populate current date
    });
    this.furtherReqService.getSpecificDate().subscribe(specificDate => {
      // Populate specific date
    });
  }

  onDoubleClickFurtherReqField(): void {
    if (!this.furtherReqService.checkGlobalCondition()) {
      this.displayErrorMessage('Raise requirements for the failed confidence rule first.');
    } else {
      this.furtherReqService.setLOV(true);
      this.furtherReqService.resetFields();
      this.navigateToItem('specificItem');
    }
  }

  handleAddNewRequirementButtonClick(): void {
    if (!this.furtherReqService.isRuleConfidenceWindowOpen() && this.furtherReqService.isRuleConfidenceWindowVisible()) {
      this.displayErrorMessage('Raise requirements for the failed confidence rule first.');
    } else {
      this.furtherReqService.getLOVValues('Y').subscribe(lovValues => {
        // Handle LOV values
      });
      this.setFocus('testNumberField');
      this.clearFields(['testNumberField', 'testDescriptionField']);
    }
  }

  setFocus(fieldName: string): void {
    // Set focus to the specified field
  }

  clearFields(fields: string[]): void {
    fields.forEach(field => {
      // Clear the field
    });
  }

  deleteRequirementButtonHandler(): void {
    const requirementId = 123; // Example requirement ID
    this.furtherReqService.validateAndDeleteRequirement(requirementId).subscribe(response => {
      // Handle response
    }, error => {
      this.handleValidationError(error);
    });
  }

  handleValidationError(error: any): void {
    // Handle validation error
  }

  validateReceiptStatus(receiptStatus: string, testNumber: string, agentCode: string, statusFlag: string): Observable<any> {
    return this.furtherReqService.validateReceiptStatus(receiptStatus, testNumber, agentCode, statusFlag);
  }

  focusOnFurtherReq(): void {
    // Use Angular's ViewChild or ElementRef to set focus on the 'fr_res_recd' input field
  }

  onButtonClick(): void {
    this.furtherReqService.processDeclaration().subscribe(response => {
      // Handle response
    });
  }

  addTestRequirement(): void {
    this.furtherReqService.addTestRequirement().subscribe(response => {
      // Handle response
    });
  }

  deleteTestRequirement(): void {
    this.furtherReqService.deleteTestRequirement().subscribe(response => {
      // Handle response
    });
  }

  fetchTestRequirements(): void {
    this.furtherReqService.getTestRequirements().subscribe(requirements => {
      // Handle requirements
    });
  }

  validateTestNumber(testNumber: string): Observable<boolean> {
    return this.furtherReqService.validateTestNumber(testNumber);
  }

  markAsReceived(testId: number): void {
    this.furtherReqService.markAsReceived(testId).subscribe(response => {
      // Handle response
    });
  }

  navigateList(direction: string): void {
    // Handle navigation through the list
  }

  handleRequirementReceivedChange(event: Event): void {
    const status = (event.target as HTMLInputElement).checked ? 'Y' : 'N';
    this.furtherReqService.updateRequirementStatus(status).subscribe(response => {
      this.updateReceivedDate(status);
    });
  }

  updateReceivedDate(status: string): void {
    if (status === 'Y') {
      // Set received date to current date
    } else {
      // Clear received date and set global flag
    }
  }

  setFocusOnAddTestField(): void {
    // Set focus on the 'Add Test' field
  }

  handleMwpActCheckboxChange(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    if (isChecked) {
      const maritalStatus = 'M'; // Example marital status
      if (this.furtherReqService.checkMaritalStatus(maritalStatus)) {
        this.furtherReqService.navigateToFurtherReqBlock();
        this.furtherReqService.createOrUpdateRecord('M470', 'MWP ADDENDUM', new Date(), 'USER CALLED');
      } else {
        this.displayErrorMessage('Proposer must be married, divorced, or widowed for insurance with MWP Act.');
      }
    } else {
      this.furtherReqService.navigateToFurtherReqBlock();
      this.furtherReqService.deleteRecord('M470');
      this.furtherReqService.deleteRelatedRecords('contractId');
    }
  }

  onTestNumberClick(): void {
    this.furtherReqService.fetchLOVData().subscribe(data => {
      // Display LOV data
    });
  }

  onTestNumberNavigate(): void {
    // Auto-populate the date called field with the current date
  }

  handleDropdownChange(event: Event): void {
    const value = (event.target as HTMLInputElement).value.toUpperCase();
    // Handle dropdown change
  }

  onTestReceivedCheckboxChange(event: Event): void {
    if ((event.target as HTMLInputElement).checked) {
      // Populate the date field with the current date
    }
  }

  displayFurtherRequirements(): void {
    this.furtherReqService.getFurtherRequirements().subscribe(requirements => {
      // Handle requirements
    });
  }

  onAddRequirementClick(): void {
    this.furtherReqService.fetchFurtherRequirements().subscribe(requirements => {
      // Handle requirements
    });
  }

  deleteRequirement(testNo: number): void {
    this.furtherReqService.deleteRequirement(testNo).subscribe(() => {
      // Handle response
    });
  }

  onOkButtonClick(): void {
    this.furtherReqService.synchronizeRecords().subscribe(response => {
      // Handle response
    });
  }

  onTestNumberChange(event: any): void {
    const testNumber = event.target.value;
    if (this.validateTestNumber(testNumber)) {
      // Display corresponding test description
    }
  }

  displayFirstRecord(): void {
    // Implement logic to display the first record
  }

  addRequirementButtonHandler(): void {
    this.furtherReqService.navigateToDeclineRequest();
  }
}
