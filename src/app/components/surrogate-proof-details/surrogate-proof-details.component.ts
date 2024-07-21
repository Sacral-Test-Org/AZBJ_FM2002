import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SurrogateProofDetailsService } from 'src/app/services/surrogate-proof-details.service';
import { SurrogateProofDetailsDTO } from 'src/app/models/surrogate-proof-details.dto';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-surrogate-proof-details',
  templateUrl: './surrogate-proof-details.component.html',
  styleUrls: ['./surrogate-proof-details.component.css']
})
export class SurrogateProofDetailsComponent implements OnInit {
  surrogateProofForm: FormGroup;
  proofTypes: string[] = [];

  constructor(
    private fb: FormBuilder,
    private surrogateProofDetailsService: SurrogateProofDetailsService,
    private logger: NGXLogger
  ) { }

  ngOnInit(): void {
    this.surrogateProofForm = this.fb.group({
      proofType: ['', Validators.required],
      proofDescription: ['', Validators.required],
      fieldValue: ['', Validators.required],
      documentDate: ['', Validators.required],
      derivedIncome: [{ value: '', disabled: true }],
      derivedTasaValue: [{ value: '', disabled: true }]
    });

    this.getProofTypes();
  }

  getProofTypes(): void {
    this.surrogateProofDetailsService.getProofTypes().subscribe(
      (data: string[]) => {
        this.proofTypes = data;
      },
      (error) => {
        this.logger.error('Error fetching proof types', error);
      }
    );
  }

  saveSurrogateProofDetails(): void {
    if (this.surrogateProofForm.valid) {
      const surrogateProofDetails: SurrogateProofDetailsDTO = this.surrogateProofForm.value;
      this.surrogateProofDetailsService.saveSurrogateProofDetails(surrogateProofDetails).subscribe(
        (response) => {
          this.logger.info('Surrogate proof details saved successfully', response);
        },
        (error) => {
          this.logger.error('Error saving surrogate proof details', error);
        }
      );
    }
  }
}
