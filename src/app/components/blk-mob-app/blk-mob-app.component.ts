import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BlkMobAppService } from '../../services/blk-mob-app.service';
import { DoctorClientNamesResponse, PartnerDetailsDTO } from '../../models/blk-mob-app.models';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-blk-mob-app',
  templateUrl: './blk-mob-app.component.html',
  styleUrls: ['./blk-mob-app.component.css']
})
export class BlkMobAppComponent {
  partnerNames: string[] = [];
  gender: string | null = null;
  ageOfClient: number | null = null;
  test: string | null = null;
  timestamp: string | null = null;

  constructor(private router: Router, private blkMobAppService: BlkMobAppService) {}

  onExitButtonClick(): void {
    this.router.navigate(['/mobile-app-info']);
  }

  onDoctorCodeSelect(doctorCode: string): void {
    this.partnerNames = [];
    this.gender = null;
    this.ageOfClient = null;
    this.test = null;
    this.timestamp = null;

    this.blkMobAppService.fetchClientNames(doctorCode).subscribe(
      (response: DoctorClientNamesResponse) => {
        this.partnerNames = response.clientNames;
      },
      (error) => {
        console.warn('Invalid doctor code');
      }
    );
  }

  onPartnerNameInput(partnerName: string): void {
    if (!partnerName) {
      this.gender = null;
      this.ageOfClient = null;
      this.test = null;
      this.timestamp = null;
      return;
    }

    this.blkMobAppService.fetchPartnerDetails(partnerName).subscribe(
      (details: PartnerDetailsDTO) => {
        this.gender = details.gender;
        this.ageOfClient = details.age;
        this.test = details.testNumber;
        this.timestamp = details.timestamp;
      },
      (error) => {
        this.gender = null;
        this.ageOfClient = null;
        this.test = null;
        this.timestamp = null;
      }
    );
  }
}
