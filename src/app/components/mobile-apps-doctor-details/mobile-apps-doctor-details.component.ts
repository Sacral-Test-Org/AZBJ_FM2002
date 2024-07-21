import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgxLoggerLevel, LoggerService } from 'ngx-logger';

@Component({
  selector: 'app-mobile-apps-doctor-details',
  templateUrl: './mobile-apps-doctor-details.component.html',
  styleUrls: ['./mobile-apps-doctor-details.component.css']
})
export class MobileAppsDoctorDetailsComponent implements OnInit {

  doctorCode: string = '';
  partnerName: string = '';
  ageOfClient: number = 0;
  gender: string = '';
  testConducted: string = '';
  timeStamp: string = '';
  longitude: string = '';
  latitude: string = '';

  constructor(private router: Router, private logger: LoggerService) { }

  ngOnInit(): void {
    this.logger.log(NgxLoggerLevel.INFO, 'MobileAppsDoctorDetailsComponent initialized');
    // Fetch necessary data here
  }

  onExit(): void {
    this.logger.log(NgxLoggerLevel.INFO, 'Exiting MobileAppsDoctorDetailsComponent');
    this.router.navigate(['/']);
  }

  onViewImages(): void {
    this.logger.log(NgxLoggerLevel.INFO, 'Viewing images in MobileAppsDoctorDetailsComponent');
    // Logic to open image viewer
  }

  onViewLocation(): void {
    this.logger.log(NgxLoggerLevel.INFO, 'Viewing location in MobileAppsDoctorDetailsComponent');
    // Logic to open map viewer
  }
}
