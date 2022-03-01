import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { catchError, map, merge,  of, startWith, switchMap } from 'rxjs';
import { BooknewsService } from 'src/app/shared/service/booknews.service';
import { CalibBooksService } from 'src/app/shared/service/calib-books.service';

@Component({
  selector: 'app-mashhurlar-hayoti',
  templateUrl: './mashhurlar-hayoti.component.html',
  styleUrls: ['./mashhurlar-hayoti.component.scss']
})
export class MashhurlarHayotiComponent implements OnInit ,AfterViewInit {

  displayedColumns: string[] = ['id', 'name', 'familiya', 'tugKun' ,'amal'];
  data = [];
  key = '';
  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;
  form: any;
  tahrir = false;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  displayFn: any;
  panelOpenState = false;
  uploadService: any;

  constructor(private CalibService:CalibBooksService,
    public fb:FormBuilder ,private _snackBar: MatSnackBar) { }

    ngOnInit(): void {
     this.form = this.fb.group({
       id:[''],
       name:[''],
       familiya:[''],
       tugKun:[''],
       
      
     })
     }



     ngAfterViewInit() {

      // If the user changes the sort order, reset back to the first page.
      this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);
      merge(this.sort.sortChange, this.paginator.page)
        .pipe(
          startWith({}),
          switchMap(() => {
            this.isLoadingResults = true;
  
            let pageable = {
              key: this.key,
              size: this.paginator.pageSize,
              sort: this.sort.active + "," + this.sort.direction,
              page: this.paginator.pageIndex
            }
  
            return this.CalibService.getAll(pageable)
              .pipe(catchError(() => of(null)));
          }),
          map((data: any) => {
            // Flip flag to show that loading has finished.
            this.isLoadingResults = false;
            this.isRateLimitReached = data === null;
  
            if (data === null) {
              return [];
            }
            // Only refresh the result length if there is new data. In case of rate
            // limit errors, we do not want to reset the paginator to zero, as that
            // would prevent users from re-triggering requests.
            this.resultsLength = data.totalElements;
            return data.content;
          })
        ).subscribe(data => this.data = data);
    }
   
    search(event: any) {
      const filterField = event.target.value; 
      if (filterField) {
        this.key = filterField;
      } else {
        this.key = ""; 
      }
      this.sort.sortChange.next(this.sort);
    }

    
    save() {
      const sinflar = this.form.getRawValue();
      this.CalibService.create(sinflar).subscribe(data => {
        this.key = "";
        this.form.reset();
        this.sort.sortChange.next(this.sort);
  
      })
    }


    edit(sinf: any) {
      this.form.reset(sinf);
      this.tahrir = true;
    }
  
    delete(row: any) {
            this.CalibService.deleteById(row.id).subscribe(() => {
              this.sort.sortChange.next(this.sort);
            })
          }

}
