import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Fantas } from '../model/fantastic';

@Injectable({
  providedIn: 'root'
})
export class FantasticService {

  api = environment.baseUrl + "/api/fantastic";

  constructor(private http: HttpClient) { }

  public getAll (page:any) :Observable<Fantas> {
    return this.http.get<any>(this.api ,{params:page});
  } 
  public create(fantas: Fantas): Observable<any> {
    return this.http.post<any>(this.api, fantas)
  }
  public update(fantas: Fantas): Observable<any> {
    return this.http.put<any>(this.api, fantas)
  }
  public deleteById(id: number): Observable<any> {
    return this.http.delete<any>(this.api + "/" + id)
  }
}
