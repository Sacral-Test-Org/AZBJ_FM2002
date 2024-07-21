import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChildCoverDetailsService {
  private apiUrl = 'http://localhost:8080/api/child-cover-details';

  constructor(private http: HttpClient) {}

  openChildCoverDetails(): void {
    // Logic to open the child cover details component
    // This could involve routing to the component or opening a modal
    console.log('Opening Child Cover Details component');
  }

  focusChildName(): void {
    // Logic to focus on the "Child Name" field
    // This could involve setting focus on an input element
    const childNameInput = document.getElementById('childName');
    if (childNameInput) {
      childNameInput.focus();
    }
  }

  saveChildDetails(childDetails: any): Observable<any> {
    // Logic to save child details, potentially making an HTTP POST request to the backend
    return this.http.post<any>(`${this.apiUrl}/save`, childDetails);
  }

  deleteChildCover(recordId: number): Observable<void> {
    // Logic to send a request to the back-end controller to delete the specified child cover record
    return this.http.delete<void>(`${this.apiUrl}/delete/${recordId}`);
  }
}
