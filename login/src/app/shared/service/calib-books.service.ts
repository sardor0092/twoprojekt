import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cali } from '../model/mashur';

@Injectable({
  providedIn: 'root'
})
export class CalibBooksService {

  api = environment.baseUrl + "/api/calib";

  constructor(private http: HttpClient) { }

  public getAll(page: any): Observable<any> {
    return this.http.get<any>(this.api, { params: page })
  }

  public create(calib: Cali): Observable<Cali> {
    return this.http.post<Cali>(this.api, calib)
  }
  public update(calib: Cali): Observable<any> {
    return this.http.put<any>(this.api, calib)
  }
  public deleteById(id: number): Observable<any> {
    return this.http.delete<any>(this.api + "/" + id)
  }
}
