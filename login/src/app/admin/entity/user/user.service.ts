import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { DeleredialogComponent } from 'src/app/deleredialog/deleredialog.component';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  api = environment.baseUrl + '/api/user'; 
  
  constructor(private http: HttpClient,private dialog: MatDialog) { }

  openConfirmDialog(msg : any){
    return this.dialog.open(
      DeleredialogComponent,{
        width: "350px",
        height: "200px", 
        data : {
          massage : msg
        }
      });
  }

  getAll(sort:any):Observable<any[]> {
    return this.http.get<any[]>(this.api, {params:{'sort': sort}});
  }

  create(user: any): Observable<any> {
    return this.http.post<any>(this.api, user);
  }

  update(user: any): Observable<any> {
    return this.http.put<any>(this.api, user);
  }

  deleteById(id: number):Observable<any> {
    return this.http.delete(this.api + "/" + id);
  }






}
