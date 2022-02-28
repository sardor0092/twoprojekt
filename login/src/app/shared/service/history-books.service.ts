import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HistoryBooksService {
  api = environment.baseUrl + "/api/history";

  constructor(private http:HttpClient) { }

  private getAll(page:any):Observable<any[]> {
    return this.http.get<any[]>(this.api ,{params:page})
  }
   private create(history:History):Observable<any> {
     return this.http.post<any>(this.api ,history)
   } 

   private update(history:History):Observable<any> {
     return this.http.put<any>(this.api ,history)
   } 
   public deleteById(id:number):Observable<any>{
   return this.http.delete<any>(this.api + "/" + id)
}

}
