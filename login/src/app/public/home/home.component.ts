import { Component, OnInit } from '@angular/core';
import { MatDialog,  } from '@angular/material/dialog';
import { LoginComponent } from 'src/app/login/login.component';
import { RegisterComponent } from "src/app/login/register/RegisterComponent";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {


  constructor(private dialog: MatDialog) {

  }
  ngOnInit(): void {

  }
  openDialog(): void {
    const dialogRef = this.dialog.open(LoginComponent, {
      width: '450px',


    });

  }
  openDialogRegister(): void {
    const dialogred = this.dialog.open(RegisterComponent, {
      minWidth: '300px',
      minHeight: '400px',

    });
  }
}