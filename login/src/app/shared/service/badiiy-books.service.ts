import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Badiiy } from '../model/baddiy';

@Injectable({
  providedIn: 'root'
})
export class BadiiyBooksService {
 
  api = environment.baseUrl + "/api/badiy";

  constructor(private http:HttpClient) { }

  public getAll (page:any) :Observable<Badiiy> {
    return this.http.get<any>(this.api ,{params:page});
  } 
  public create(baddiy:Badiiy):Observable<any> {
    return this.http.post<any>(this.api ,baddiy);
  }
  public update(baddiy:Badiiy):Observable<any> {
    return this.http.put<any>(this.api ,baddiy);
  }
  public deleteById(id:number):Observable<any> {
    return this.http.delete<any>(this.api + "/" + id);
  }
 


}
