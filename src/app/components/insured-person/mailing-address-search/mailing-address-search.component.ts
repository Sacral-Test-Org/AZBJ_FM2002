import { Component } from '@angular/core';
import { InsuredPersonService } from 'src/app/services/insured-person.service';
import { MailingAddressDTO } from 'src/app/models/mailing-address-dto.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-mailing-address-search',
  templateUrl: './mailing-address-search.component.html',
  styleUrls: ['./mailing-address-search.component.css']
})
export class MailingAddressSearchComponent {
  selectedPartner: any;
  mailingAddress: MailingAddressDTO;

  constructor(private insuredPersonService: InsuredPersonService, private logger: NGXLogger) {}

  onSearchButtonClick(): void {
    if (!this.selectedPartner) {
      this.logger.error('A partner must be selected before searching for a mailing address.');
      alert('A partner must be selected before searching for a mailing address.');
      return;
    }

    this.insuredPersonService.searchMailingAddress().subscribe(
      (data: MailingAddressDTO) => {
        if (data) {
          this.displayMailingAddress(data);
        } else {
          this.logger.warn('No mailing address selected.');
          alert('Please select a mailing address.');
        }
      },
      (error) => {
        this.logger.error('Error retrieving mailing address:', error);
        alert('Error retrieving mailing address.');
      }
    );
  }

  displayMailingAddress(mailingAddress: MailingAddressDTO): void {
    this.mailingAddress = mailingAddress;
    // Populate the insured person's mailing address fields with the retrieved data
    // Assuming there are form controls or fields to display the data
    // Example:
    // this.form.controls['addressLine1'].setValue(mailingAddress.addressLine1);
    // this.form.controls['addressLine2'].setValue(mailingAddress.addressLine2);
    // ... and so on for other fields
  }
}
