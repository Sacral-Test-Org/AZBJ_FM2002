import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { DoctorSignatureService } from 'src/app/services/doctor-signature.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-doctor-signature',
  templateUrl: './doctor-signature.component.html',
  styleUrls: ['./doctor-signature.component.css']
})
export class DoctorSignatureComponent implements OnInit {
  doctorSignatureForm: FormGroup;
  signatureImage: string | null = null;
  message: string = '';

  constructor(
    private fb: FormBuilder,
    private location: Location,
    private doctorSignatureService: DoctorSignatureService,
    private logger: NGXLogger
  ) {
    this.doctorSignatureForm = this.fb.group({
      doctorCode: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  navigateBack(): void {
    this.logger.debug('Navigating back to the previous screen');
    this.location.back();
  }

  resetForm(): void {
    this.logger.debug('Resetting the doctor signature form');
    this.doctorSignatureForm.reset();
    this.signatureImage = null;
    this.message = '';
  }

  onSubmit(): void {
    if (this.doctorSignatureForm.valid) {
      const doctorCode = this.doctorSignatureForm.get('doctorCode')?.value;
      this.logger.debug(`Verifying doctor signature for code: ${doctorCode}`);
      this.doctorSignatureService.verifyDoctorSignature(doctorCode).subscribe(
        (response) => {
          if (response.signature) {
            this.signatureImage = response.signature;
            this.message = 'Signature verified successfully';
          } else {
            this.signatureImage = null;
            this.message = 'No signature found for the provided doctor code';
          }
        },
        (error) => {
          this.logger.error('Error verifying doctor signature', error);
          this.signatureImage = null;
          this.message = 'An error occurred while verifying the signature';
        }
      );
    } else {
      this.message = 'Please enter a valid doctor code';
    }
  }
}
