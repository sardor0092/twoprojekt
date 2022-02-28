import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "../public/home/home.component";
import { LoginComponent } from "./login.component";
import { RegisterComponent } from "./register/RegisterComponent";

const routes: Routes = [
    {
      path: '',
      component: LoginComponent
    },
    {
      path: 'register',
      component: RegisterComponent
    }
  ];



@NgModule({
   imports:[RouterModule.forChild(routes)],
   exports:[RouterModule]
})


export class LoginRoutingModule {}