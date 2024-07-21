import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RcuCommentsService {
  private apiUrl = 'http://your-api-url/rcu-comments';

  constructor(private http: HttpClient) {}

  getRcuComments(params: { [key: string]: any }): Observable<any> {
    let httpParams = new HttpParams();
    for (const key in params) {
      if (params.hasOwnProperty(key)) {
        httpParams = httpParams.set(key, params[key]);
      }
    }
    return this.http.get<any>(this.apiUrl, { params: httpParams });
  }
}
