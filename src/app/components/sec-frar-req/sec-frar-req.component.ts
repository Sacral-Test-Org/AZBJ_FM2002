import { Component, OnInit } from '@angular/core';
import { SecFrarReqService } from 'src/app/services/sec-frar-req.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-sec-frar-req',
  templateUrl: './sec-frar-req.component.html',
  styleUrls: ['./sec-frar-req.component.css']
})
export class SecFrarReqComponent implements OnInit {
  frarRequirements: any[] = [];
  supervisorId: string = '';
  password: string = '';
  supervisorComments: string = '';
  testNumber: string = '';
  uwReason: number | null = null;
  uwReasonDisplay: string = '';

  constructor(private secFrarReqService: SecFrarReqService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.fetchFrarRequirements();
  }

  fetchFrarRequirements(): void {
    this.secFrarReqService.getFrarRequirements().subscribe(
      (data) => {
        this.frarRequirements = data;
      },
      (error) => {
        this.logger.error('Error fetching FRAR requirements', error);
      }
    );
  }

  saveComments(): void {
    if (this.supervisorComments.length > 500) {
      alert('Supervisor comments cannot exceed 500 characters.');
      return;
    }
    this.secFrarReqService.saveSupervisorComments(this.supervisorComments).subscribe(
      (response) => {
        alert('Comments saved successfully.');
      },
      (error) => {
        this.logger.error('Error saving comments', error);
      }
    );
  }

  authenticate(): void {
    if (!this.uwReason) {
      alert('U/W Reason not selected');
      return;
    }
    if (this.uwReason === 1 && !this.supervisorComments) {
      alert('Please Select Supervisor comment');
      return;
    }
    if (!this.supervisorId) {
      alert('Please enter Supervisor ID');
      return;
    }
    if (!this.password) {
      alert('Please enter Password');
      return;
    }
    this.secFrarReqService.approveRequest(this.supervisorId, this.password).subscribe(
      (response) => {
        alert('Approved');
        this.frarRequirements.forEach((req) => {
          req.supervisorId = this.supervisorId;
          req.password = this.password;
          req.authFlag = 'Y';
        });
      },
      (error) => {
        this.logger.error('Error during approval', error);
        alert('Approval failed: ' + error.message);
      }
    );
  }

  onSupervisorIdChange(event: Event): void {
    const input = (event.target as HTMLInputElement).value;
    if (input.length <= 10) {
      this.supervisorId = input.toUpperCase();
    }
  }

  onSupervisorIdBlur(): void {
    // Apply visual attribute to indicate the field has been processed
    const supervisorIdField = document.getElementById('supervisorId');
    if (supervisorIdField) {
      supervisorIdField.style.border = '2px solid green';
    }
  }

  handlePasswordField(): void {
    const passwordField = document.getElementById('password');
    if (passwordField) {
      passwordField.type = 'password';
      passwordField.style.border = '2px solid blue';
    }
  }

  onDoubleClickSupervisorComments(): void {
    this.fetchLOVValues(this.testNumber).subscribe(
      (lovValues) => {
        // Display LOV values
        const lovList = lovValues.join(', ');
        alert('LOV: ' + lovList);
      },
      (error) => {
        this.logger.error('Error fetching LOV values', error);
      }
    );
  }

  fetchLOVValues(testNumber: string): Observable<string[]> {
    return this.secFrarReqService.getLOVValues(testNumber);
  }

  handleDropdownSelection(event: Event): void {
    const selectedValue = (event.target as HTMLSelectElement).value;
    this.uwReasonDisplay = selectedValue.toUpperCase();
  }

  handleKeyboardNavigation(event: KeyboardEvent): void {
    const dropdown = document.getElementById('lifeDropdown');
    if (dropdown) {
      if (event.key === 'ArrowDown') {
        dropdown.focus();
      }
    }
  }

  onReasonChange(reason: number): void {
    this.secFrarReqService.getReasonDescription(reason).subscribe(
      (description) => {
        this.uwReasonDisplay = description;
        if (reason === 2 || reason === 3) {
          this.supervisorComments = '';
          const commentsField = document.getElementById('supervisorComments');
          if (commentsField) {
            commentsField.setAttribute('readonly', 'true');
          }
        } else if (reason === 1) {
          const commentsField = document.getElementById('supervisorComments');
          if (commentsField) {
            commentsField.removeAttribute('readonly');
          }
        }
      },
      (error) => {
        this.logger.error('Error fetching reason description', error);
      }
    );
  }

  validateFields(): void {
    if (!this.uwReason) {
      alert('U/W Reason not selected');
      const uwReasonField = document.getElementById('uwReason');
      if (uwReasonField) {
        uwReasonField.focus();
      }
      return;
    }
    if (this.uwReason === 1 && !this.supervisorComments) {
      alert('Please Select Supervisor comment');
      const commentsField = document.getElementById('supervisorComments');
      if (commentsField) {
        commentsField.focus();
      }
      return;
    }
    if (!this.supervisorId) {
      alert('Please enter Supervisor ID');
      const supervisorIdField = document.getElementById('supervisorId');
      if (supervisorIdField) {
        supervisorIdField.focus();
      }
      return;
    }
    if (!this.password) {
      alert('Please enter Password');
      const passwordField = document.getElementById('password');
      if (passwordField) {
        passwordField.focus();
      }
      return;
    }
  }

  approveRequest(supervisorId: string, password: string): void {
    this.secFrarReqService.approveRequest(supervisorId, password).subscribe(
      (response) => {
        alert('Approved');
        this.frarRequirements.forEach((req) => {
          req.supervisorId = supervisorId;
          req.password = password;
          req.authFlag = 'Y';
        });
      },
      (error) => {
        this.logger.error('Error during approval', error);
        alert('Approval failed: ' + error.message);
      }
    );
  }

  handleUwReasonDisplayClick(): void {
    if (this.testNumber === 'M393') {
      this.displayLov(['Suspect document', 'Image not clear']);
    } else {
      this.displayLov(['Document Required', 'Internal Requirement', 'Image not clear']);
    }
    this.navigateToSupervisorComments();
  }

  displayLov(lovOptions: string[]): void {
    const lovList = lovOptions.join(', ');
    alert('LOV: ' + lovList);
  }

  navigateToSupervisorComments(): void {
    const commentsField = document.getElementById('supervisorComments');
    if (commentsField) {
      commentsField.focus();
    }
  }
}
