import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { Observable, ReplaySubject, of } from 'rxjs';
import { shareReplay, tap, catchError, map } from 'rxjs/operators';
import { User } from '../shared/model/user';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AccountService {

  private userIdentity: User | null = null;
  private authenticationState = new ReplaySubject<User | null>(1);
  private userCache$?: Observable<User | null>;
  private baseApi = environment.baseUrl + "/api/account";
  constructor(
    private http: HttpClient,
    private router: Router,
  ) { }

  save(user: User): Observable<{}> {
    return this.http.post(this.baseApi, user);
  }

  authenticate(identity: User | null): void {
    
    this.userIdentity = identity;
    this.authenticationState.next(this.userIdentity);
  }
  hasAnyAuthority(lavozimlar: string[] | string): boolean {
    if (!this.userIdentity) {
      return false;
    }
    if (!Array.isArray(lavozimlar)) {
      lavozimlar = [lavozimlar];
    }
    return this.userIdentity.lavozimlar.some((lavozim: string) => lavozimlar.includes(lavozim));
  }

  identity(force?: boolean): Observable<User | null> {

    if (!this.userCache$ || force || !this.isAuthenticated()) {
      this.userCache$ = this.fetch().pipe(
        catchError((e) => {
          console.log('xatolik', e);

          return of(null)
        }),
        (res) => {
          console.log(res);
         res.subscribe(u=>{
                     this.authenticate(u);

         })
          return res;

        }
      );

    }
    return this.userCache$;
  }

  isAuthenticated(): boolean {
    return this.userIdentity !== null;
  }

  getAuthenticationState(): Observable<User | null> {
    return this.authenticationState.asObservable();
  }



  private fetch(): Observable<User> {
    console.log('fetching . . .');

    return this.http.get<User>(this.baseApi);

  }


}
