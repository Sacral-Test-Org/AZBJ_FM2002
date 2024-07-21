import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SofaInfoBoilerService } from 'src/app/services/sofa-info-boiler.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-sofa-info-boiler',
  templateUrl: './sofa-info-boiler.component.html',
  styleUrls: ['./sofa-info-boiler.component.css']
})
export class SofaInfoBoilerComponent implements OnInit {
  boilerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private sofaInfoBoilerService: SofaInfoBoilerService,
    private logger: NGXLogger
  ) { }

  ngOnInit(): void {
    this.boilerForm = this.fb.group({
      policyNumber: [''],
      agentNumber: [''],
      policyHolder: [''],
      policyStatus: [''],
      effectiveDate: ['', [Validators.required, Validators.pattern(/\d{4}-\d{2}-\d{2}/)]]
    });
  }

  onSubmit(): void {
    if (this.boilerForm.valid) {
      const formValues = this.boilerForm.value;
      this.logger.info('Form Submitted', formValues);
      // Here you can add the logic to send the form data to the backend using sofaInfoBoilerService
    } else {
      this.logger.error('Form is invalid');
    }
  }
}
