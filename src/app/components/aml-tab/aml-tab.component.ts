import { Component, OnInit } from '@angular/core';
import { AmlService } from '../../services/aml.service';
import { PanDetailsDTO } from '../../models/pan-details-dto.model';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-aml-tab',
  templateUrl: './aml-tab.component.html',
  styleUrls: ['./aml-tab.component.css']
})
export class AmlTabComponent implements OnInit {
  panDetails: PanDetailsDTO[] = [];

  constructor(private amlService: AmlService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.logger.debug('Fetching PAN details');
    this.amlService.getPanDetails().subscribe(
      (data: PanDetailsDTO[]) => {
        this.panDetails = data;
        this.logger.debug('PAN details fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching PAN details', error);
      }
    );
  }
}
