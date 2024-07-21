import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GstCalculationRequest } from 'src/main/java/com/azbj/fm2002/dto/GstCalculationRequest';
import { GstCalculationResponse } from 'src/main/java/com/azbj/fm2002/dto/GstCalculationResponse';

@Injectable({
  providedIn: 'root'
})
export class AzbjCoDetailsService {
  private generateBiReportUrl = 'api/bi-report/generate';
  private calculateGstUrl = 'api/gst/calculate';

  constructor(private http: HttpClient) {}

  generateBiReport(): Observable<any> {
    return this.http.post<any>(this.generateBiReportUrl, {});
  }

  calculateGst(request: GstCalculationRequest): Observable<GstCalculationResponse> {
    return this.http.post<GstCalculationResponse>(this.calculateGstUrl, request);
  }
}