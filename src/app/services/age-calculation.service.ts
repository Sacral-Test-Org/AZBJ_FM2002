import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AgeCalculationService {

  calculateAge(dob: string): number | null {
    if (!dob) {
      return null;
    }
    try {
      const birthDate = new Date(dob);
      const currentDate = new Date();
      let age = currentDate.getFullYear() - birthDate.getFullYear();
      const monthDifference = currentDate.getMonth() - birthDate.getMonth();
      if (monthDifference < 0 || (monthDifference === 0 && currentDate.getDate() < birthDate.getDate())) {
        age--;
      }
      return age;
    } catch (error) {
      return null;
    }
  }
}
