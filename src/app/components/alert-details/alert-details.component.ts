import { Component, OnInit } from '@angular/core';
import { AlertDetailsService } from '../../services/alert-details.service';
import { AlertDetails } from '../../models/alert-details.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-alert-details',
  templateUrl: './alert-details.component.html',
  styleUrls: ['./alert-details.component.css']
})
export class AlertDetailsComponent implements OnInit {
  alertDetails: AlertDetails;

  constructor(private alertDetailsService: AlertDetailsService) { }

  ngOnInit(): void {
    this.alertDetailsService.getAlertDetails().subscribe((data: AlertDetails) => {
      this.alertDetails = data;
    });
  }
}
