import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Dars } from '../model/dars';

@Injectable({
  providedIn: 'root'
})
export class DarsBooksService {
  api = environment.baseUrl + "/api/lesson";

  constructor(private http:HttpClient) { }

  public getAll(page:any):Observable<any> {
    return this.http.get<any>(this.api ,{params:page})
  }

  public create(dars:Dars):Observable<Dars> {
    return this.http.post<Dars>(this.api ,dars)
  }

  public update(dars:Dars):Observable<Dars>{
    return this.http.put<Dars>(this.api ,dars)
  }
  public deleteById(id:number):Observable<any> {
    return this.http.delete<any>(this.api + "/" +id)
  }
}
