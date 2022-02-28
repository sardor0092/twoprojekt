import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tizim } from '../model/tizim';

@Injectable({
  providedIn: 'root'
})
export class TizimgaService {

  api = environment.baseUrl + "/api/topbooks";



  constructor(private http:HttpClient) { }

  public getAll(page:any):Observable<Tizim> {
    return this.http.get<any>(this.api ,{params:page})
  }

  public create(tizim:Tizim):Observable<any> {
    return this.http.post<any>(this.api,tizim)
  }
  public update(tizim:Tizim):Observable<Tizim> {
    return this.http.put<Tizim>(this.api,tizim);
  }
  public deleteById(id:number):Observable<Tizim>{
    return this.http.delete<Tizim>(this.api + "/"  + id)
  }
}
