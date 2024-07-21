import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoggerService } from 'ngx-logger';

interface Rider {
  riderCode: string;
  riderDescription: string;
  sumAssured: number;
}

@Component({
  selector: 'app-c-offer-rider',
  templateUrl: './c-offer-rider.component.html',
  styleUrls: ['./c-offer-rider.component.css']
})
export class COfferRiderComponent implements OnInit {
  riderForm: FormGroup;
  riders: Rider[] = [];

  constructor(private fb: FormBuilder, private logger: LoggerService) {
    this.riderForm = this.fb.group({
      riderCode: ['', Validators.required],
      riderDescription: ['', Validators.required],
      sumAssured: ['', [Validators.required, Validators.min(0)]]
    });
  }

  ngOnInit(): void {
    this.loadRiders();
  }

  loadRiders(): void {
    // Placeholder for loading existing riders, e.g., from a service
    this.riders = [
      { riderCode: 'RC001', riderDescription: 'Rider 1', sumAssured: 10000 },
      { riderCode: 'RC002', riderDescription: 'Rider 2', sumAssured: 20000 },
      { riderCode: 'RC003', riderDescription: 'Rider 3', sumAssured: 30000 },
      { riderCode: 'RC004', riderDescription: 'Rider 4', sumAssured: 40000 }
    ];
  }

  addRider(): void {
    if (this.riderForm.valid) {
      const newRider: Rider = this.riderForm.value;
      this.riders.push(newRider);
      this.logger.info('Rider added:', newRider);
      this.riderForm.reset();
    }
  }

  removeRider(index: number): void {
    const removedRider = this.riders.splice(index, 1);
    this.logger.info('Rider removed:', removedRider);
  }
}
