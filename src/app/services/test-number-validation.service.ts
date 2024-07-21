import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestNumberValidationService {
  private predefinedTestNumbers: string[] = ['TEST001', 'TEST002', 'TEST003'];

  constructor() {}

  validateTestNumber(testNumber: string): boolean {
    return this.predefinedTestNumbers.includes(testNumber);
  }
}
