import { Component, OnInit } from '@angular/core';
import { PanelDoctorService } from 'src/app/services/panel-doctor.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DoctorDetails, DoctorPanelData, ImageData, DoctorCodeValidationResponse, PanelDoctorValidationResponse } from 'src/app/models/panel-doctor.model';
import { ValidationErrorComponent } from 'src/app/components/panel-doctor/validation-error/validation-error.component';
import { ConfirmationDialogComponent } from 'src/app/components/panel-doctor/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-panel-doctor',
  templateUrl: './panel-doctor.component.html',
  styleUrls: ['./panel-doctor.component.css']
})
export class PanelDoctorComponent implements OnInit {
  constructor(private panelDoctorService: PanelDoctorService, private router: Router) {}

  ngOnInit(): void {
    this.panelDoctorService.getOpusDate().subscribe(opusDate => {
      // Set the 'Date Received' field to non-editable and store the opus date
      // Assuming there's a form control named 'dateReceived'
      this.dateReceivedControl.disable();
      this.opusDate = opusDate;
    });
  }

  validateDoctorCode(doctorCode: string): void {
    this.panelDoctorService.validateDoctorCode(doctorCode).subscribe((doctorDetails: DoctorDetails) => {
      // Logic to display doctor details
      this.doctorDetails = doctorDetails;
    });
  }

  deleteDoctor(doctorCode: string): void {
    this.panelDoctorService.deleteDoctor(doctorCode).subscribe(() => {
      // Logic to handle successful deletion
      this.refreshDoctorPanel();
    });
  }

  populateDoctorPanel(): void {
    this.panelDoctorService.populateDoctorPanel().subscribe((doctorPanelData: DoctorPanelData) => {
      // Logic to populate doctor panel
      this.doctorPanelData = doctorPanelData;
    });
  }

  viewImages(doctorCode: string): void {
    this.panelDoctorService.viewImages(doctorCode).subscribe((images: ImageData[]) => {
      // Logic to view images
      this.images = images;
    });
  }

  validateMerNo(merNo: string): void {
    if (isNaN(Number(merNo))) {
      this.merNoControl.setValue('');
      ValidationErrorComponent.showError('Please enter a valid MER No.');
    }
  }

  validateDateReceived(dateReceived: string): void {
    this.panelDoctorService.getOpusDate().subscribe(opusDate => {
      if (dateReceived !== opusDate) {
        ValidationErrorComponent.showError('Received Date should be equal to opus date');
      }
    });
  }

  onViewImagesButtonClick(): void {
    if (this.policyRef) {
      const url = `https://example.com/images?ref=${this.policyRef}`;
      window.open(url, '_blank');
    } else {
      ValidationErrorComponent.showError('Invalid policy reference');
    }
  }

  onLifeTypeChange(lifeType: string): void {
    const currentDoctorCode = this.doctorCodeControl.value;
    this.panelDoctorService.validateDoctorCode(lifeType, this.testCode, this.applicationNo).subscribe((response: DoctorCodeValidationResponse) => {
      if (response.doctorCode && response.doctorCode !== currentDoctorCode) {
        const confirm = window.confirm('The doctor code has changed. Do you want to proceed?');
        if (confirm) {
          this.doctorCodeControl.setValue(response.doctorCode);
        }
      }
    });
  }

  navigateToDoctorSignature(): void {
    this.router.navigate(['/doctor-signature']);
  }

  onDoctorNameDoubleClick(): void {
    this.panelDoctorService.fetchDoctorNames().subscribe((doctors) => {
      // Logic to display LOV with doctor names
      this.doctorNames = doctors;
    });
  }

  handleTestCodeEntry(testCode: string): void {
    this.panelDoctorService.validateTestCode(testCode).subscribe((response: PanelDoctorValidationResponse) => {
      if (!this.dateReceivedControl.value) {
        this.dateReceivedControl.setValue(new Date().toISOString().split('T')[0]);
      }
      if (!response.isAuthorized) {
        const confirm = window.confirm('The doctor is not authorized to perform this test. Do you want to continue?');
        if (!confirm) {
          this.testCodeControl.setErrors({ unauthorized: true });
        }
      }
      if (testCode !== 'MER') {
        this.docMerNoControl.disable();
        this.docMerNoControl.setValue('');
      } else {
        this.docMerNoControl.enable();
      }
    });
  }

  showConfirmationDialog(message: string): Observable<boolean> {
    return ConfirmationDialogComponent.open(message);
  }

  deleteDoctorRecord(doctorCode: string, testCode: string): void {
    this.panelDoctorService.checkPaymentStatusAndDelete(doctorCode, testCode).subscribe(() => {
      // Logic to handle successful deletion
      this.refreshDoctorPanel();
    }, (error) => {
      ValidationErrorComponent.showError('Payment made to doctor. You cannot delete the record.');
    });
  }

  onPopulateDoctorPanelClick(): void {
    this.showConfirmationDialog('Do you want to clear the existing doctor panel?').subscribe((confirmed) => {
      if (confirmed) {
        this.clearDoctorPanel();
      }
      this.panelDoctorService.fetchDoctorDetails().subscribe((doctorDetails) => {
        this.updateDoctorPanel(doctorDetails);
      });
    });
  }

  updateDoctorPanel(doctorDetails: any[]): void {
    // Logic to update the doctor panel with fetched details
    this.doctorPanel = doctorDetails;
  }

  private refreshDoctorPanel(): void {
    // Logic to refresh the doctor panel
  }

  private clearDoctorPanel(): void {
    // Logic to clear the doctor panel
  }
}
