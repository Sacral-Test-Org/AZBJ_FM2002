import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-list-of-values',
  templateUrl: './list-of-values.component.html',
  styleUrls: ['./list-of-values.component.css']
})
export class ListOfValuesComponent {
  @Output() coverCodeSelected = new EventEmitter<string>();
  coverCodes: { coverCode: string, coverDescription: string }[] = [];

  constructor(private http: HttpClient, private logger: NGXLogger) {}

  ngOnInit() {
    this.fetchCoverCodes();
  }

  fetchCoverCodes() {
    const query = `SELECT B.COVER_CODE, C.cover_description
                   FROM AZBJ_PACKAGE_MASTER A, AZBJ_PACKAGE_COVERS B, CFG_V_PROD_COVERS_API C
                   WHERE A.PACKAGE_CODE = B.PACKAGE_CODE
                     AND A.PRODUCT_ID = :CONTROL.CN_PRODUCT_ID
                     AND A.PACKAGE_CODE = :COVERHEAD.CH_PACKAGE_CODE
                     AND A.PRODUCT_ID = C.PRODUCT_ID
                     AND B.COVER_CODE = C.COVER_CODE
                   ORDER BY B.COVER_CODE;`;
    this.http.post<any[]>('/api/cover-codes', { query }).subscribe(
      data => {
        this.coverCodes = data;
      },
      error => {
        this.logger.error('Error fetching cover codes', error);
      }
    );
  }

  selectCoverCode(coverCode: string) {
    this.coverCodeSelected.emit(coverCode);
  }
}
