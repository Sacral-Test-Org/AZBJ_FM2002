import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReasonsListService {
  private reasons: string[] = [
    'Reason 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    'Reason 2: Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
    'Reason 3: Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    'Reason 4: Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.',
    'Reason 5: Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
    'Reason 6: Curabitur pretium tincidunt lacus. Nulla gravida orci a odio.',
    'Reason 7: Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris.',
    'Reason 8: Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula.',
    'Reason 9: Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam.',
    'Reason 10: Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi.'
  ];

  constructor() {}

  getReasons(): Observable<string[]> {
    return of(this.reasons);
  }
}
