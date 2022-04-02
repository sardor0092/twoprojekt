import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MessageTexts } from 'src/app/core/messege-texts';
import { DeleredialogComponent } from 'src/app/deleredialog/deleredialog.component';
import { Lavozim } from 'src/app/shared/model/Lavozim';
import { User } from 'src/app/shared/model/user';

import { UserService } from './user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit, AfterViewInit {

  panelOpenState = false;
  displayedColumns: string[] = ['id', 'ism', 'familiya', 'login', 'aktiv', 'amal'];


  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) matSort!: MatSort;



  pageSize = 10;
  userlar: any[] = [];

  lazovim: Lavozim[] = [];
  tahrirRejim = false;
  sort = 'id';
  sortType = 'asc'
  sorovBajarilmoqda = false;
  surovBajarilmoqda = false;
  registerForm: any;
  minDate: Date;
  maxDate: Date;
  createForm: any;
  activeCheck = false;

  constructor(
    public userService: UserService,

    private formBuilder: FormBuilder,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar
  ) {
    // Set the minimum to January 1st 20 years in the past and December 31st a year in the future.
    const currentYear = new Date().getFullYear();
    this.minDate = new Date(currentYear - 60, 0, 0);
    this.maxDate = new Date(currentYear + 0, 0, 0);

  }








  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      id: [{ value: '', disabled: true }],
      ism: [null, Validators.required],
      familiya: [null, Validators.required],
      login: [null, [Validators.required, Validators.minLength(6)]],
      parol: [null, [Validators.required, Validators.minLength(6)]],
      aktiv: [false]
    });

  }

  ngAfterViewInit(): void {
    this.loadUser();
    
  }
  loadUser(){
    this.userlar = [];
this.isLoadingResults = true;
    this.isRateLimitReached = false;



    this.userService.getAll(null).subscribe(
      (success: any) => {
        if (success != null) {
          console.log(success);
          this.userlar = success;
        } else {
          this.userlar = [];
        }


      },
      (error) => {
        console.log(error);
        this.isRateLimitReached = true;
        this.isLoadingResults = false;
      },
      () => {
        this.isLoadingResults = false;
      }
    )
  }
 
  save(): void {
    const u = this.createForm.getRawValue();

    this.sorovBajarilmoqda = true;

    if (this.tahrirRejim) {
      this.userService.update(u).subscribe(
        (success) => {
          this.loadUser();
          this.createForm.reset();
          this.tahrirRejim = false;
          this.sorovBajarilmoqda = false;

        },
        (error) => {


          let message = MessageTexts.errorMessage;
          console.log(error);

          if (error.error?.message) {
            message = error.error.message;
          }
          this._snackBar.open(message, 'X', {
            duration: 4000,
            verticalPosition: 'bottom',

          });
          this.sorovBajarilmoqda = false;
        },

      );
    } else {

      this.userService.create(u).subscribe(
        (success) => {
          this.loadUser();
          this.createForm.reset();
          this._snackBar.open(MessageTexts.successMessage, "", {
            duration: 1000,
            verticalPosition: 'top',
            panelClass: 'notif-success'

          });
          this.sorovBajarilmoqda = false;
        },
        (error) => {
          let message = MessageTexts.errorMessage;
          console.log(error);

          if (error.error?.message) {
            message = error.error.message;
          }
          this._snackBar.open(message, 'X', {
            duration: 4000,
            verticalPosition: 'bottom',


          });
          this.sorovBajarilmoqda = false;
        }

      );
    }

  }




  ochirish(user: any) {

    this.tozalash();
    // const message = `Siz rostdan ham ushbu mahsulot turni o'chirmoqchimisiz?`;

    // const dialogData = new ConfirmDialogModel("O'chirish", message);

    const dialogRef = this.dialog.open(DeleredialogComponent, {
      maxWidth: "400px",
      // data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.userService.deleteById(user.id).subscribe(
          (success) => {
            this.ngAfterViewInit();
          },
          (error) => {
            console.log(error);
          },
          () => {

          }
        );
      };
    });
  }

  tozalash() {
    this.createForm.reset();
    this.tahrirRejim = false;
    this.sorovBajarilmoqda = false;
    this.panelOpenState = false;
  }


  saralash(sort: string) {
    if (this.sort == sort) {
      if (this.sortType == 'asc') {
        this.sortType = 'desc';
      } else {
        this.sortType = 'asc';
      }

    } else {
      this.sortType = 'asc';
      this.sort = sort;
    }
    this.sort = sort;
    this.ngAfterViewInit();
  }

  edit(elm: any) {

  }
  disactivate(elm: any) {

  }
}