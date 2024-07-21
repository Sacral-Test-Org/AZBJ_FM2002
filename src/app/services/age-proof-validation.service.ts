import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AgeProofValidationService {
  private validAgeProofIds: string[] = ['ID1', 'ID2', 'ID3']; // Predefined list of valid IDs

  constructor() {}

  validateAgeProof(ageProofId: string): boolean {
    if (!ageProofId) {
      return false;
    }
    const upperCaseId = ageProofId.toUpperCase();
    return this.validAgeProofIds.includes(upperCaseId);
  }
}
