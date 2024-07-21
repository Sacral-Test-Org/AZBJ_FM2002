import { Component, OnInit } from '@angular/core';
import { SpouseDetailsService } from 'src/app/services/spouse-details.service';
import { ProofTypeDTO } from 'src/app/models/proof-type-dto.model';
import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-proof-type-list',
  templateUrl: './proof-type-list.component.html',
  styleUrls: ['./proof-type-list.component.css']
})
export class ProofTypeListComponent implements OnInit {
  proofTypes: ProofTypeDTO[] = [];
  selectedProofType: ProofTypeDTO | null = null;

  constructor(private spouseDetailsService: SpouseDetailsService, private logger: NGXLogger) {}

  ngOnInit(): void {
    this.logger.debug('Fetching proof types');
    this.spouseDetailsService.getProofTypes().subscribe(
      (data: ProofTypeDTO[]) => {
        this.proofTypes = data;
        this.logger.debug('Proof types fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching proof types', error);
      }
    );
  }

  onProofTypeSelect(event: Event): void {
    const selectedProofTypeId = (event.target as HTMLSelectElement).value;
    this.selectedProofType = this.proofTypes.find(pt => pt.id === selectedProofTypeId) || null;
    if (this.selectedProofType) {
      this.logger.debug('Selected proof type', this.selectedProofType);
      this.spouseDetailsService.saveProofType(this.selectedProofType).subscribe(
        (response) => {
          this.logger.debug('Proof type saved successfully', response);
        },
        (error) => {
          this.logger.error('Error saving proof type', error);
        }
      );
    }
  }
}
