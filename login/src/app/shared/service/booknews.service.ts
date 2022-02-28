import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Booknews } from '../model/booknews';

@Injectable({
  providedIn: 'root'
})
export class BooknewsService {

  api = environment.baseUrl + "/api/booknews";

  constructor(private http: HttpClient) { }

  public getAll(page: any): Observable<any> {
    return this.http.get<any[]>(this.api, { params: page });
  }

  public create(booknews: Booknews): Observable<Booknews> {
    return this.http.post<Booknews>(this.api, booknews);
  }

  public update(booknews: Booknews): Observable<Booknews> {
    return this.http.put<Booknews>(this.api, booknews);

  }
  public deleteById(id: number): Observable<any> {
    return this.http.delete(this.api + "/" + id);
  }
}
