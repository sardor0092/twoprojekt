import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { World } from '../model/world';

@Injectable({
  providedIn: 'root'
})
export class WorldBookService {
  api = environment.baseUrl + "/api/world"

  constructor(private http: HttpClient) { }

  public getAll(page: any): Observable<any> {
    return this.http.get<any>(this.api, { params: page })
  }
  public create(world: World): Observable<any> {
    return this.http.post<any>(this.api, world)
  }
  public update(world: World): Observable<any> {
    return this.http.put<any>(this.api, world)
  }
  public deleteById(id: number): Observable<any> {
    return this.http.delete(this.api + "/" + id)
  }


}
