import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SaveChangesRequest } from 'src/main/java/com/azbj/fm2002/dto/SaveChangesRequest';
import { SaveChangesResponse } from 'src/main/java/com/azbj/fm2002/dto/SaveChangesResponse';
import { ExitValidationResponse } from 'src/main/java/com/azbj/fm2002/dto/ExitValidationResponse';

@Injectable({
  providedIn: 'root'
})
export class HorizontalToolbarService {
  private baseUrl = 'http://localhost:8080/api/horizontal-toolbar';

  constructor(private http: HttpClient) {}

  validateExit(): Observable<ExitValidationResponse> {
    return this.http.get<ExitValidationResponse>(`${this.baseUrl}/validate-exit`);
  }

  saveChanges(request: SaveChangesRequest): Observable<SaveChangesResponse> {
    return this.http.post<SaveChangesResponse>(`${this.baseUrl}/save-changes`, request);
  }

  enableCommitFormButton(): void {
    // Logic to enable the "Commit Form" button
    const commitFormButton = document.getElementById('commitFormButton');
    if (commitFormButton) {
      commitFormButton.disabled = false;
    }
  }
}
