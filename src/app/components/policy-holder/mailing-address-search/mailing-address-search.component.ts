import { Component, OnInit } from '@angular/core';
import { MailingAddressDTO } from 'src/app/models/mailing-address-dto.model';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-mailing-address-search',
  templateUrl: './mailing-address-search.component.html',
  styleUrls: ['./mailing-address-search.component.css']
})
export class MailingAddressSearchComponent implements OnInit {
  mailingAddress: MailingAddressDTO;

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  ngOnInit(): void {}

  displayMailingAddress(mailingAddress: MailingAddressDTO): void {
    if (!mailingAddress) {
      this.logger.error('No mailing address selected.');
      alert('Please select a mailing address.');
      return;
    }

    this.mailingAddress = mailingAddress;
    this.logger.info('Mailing address details displayed:', mailingAddress);
  }
}
