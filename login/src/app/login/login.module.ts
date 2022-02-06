import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/shared/material/material.module";
import { LoginRoutingModule } from "./login-routing.module";
import { LoginComponent } from "./login.component";
import { RegisterComponent } from "./register/RegisterComponent";

@NgModule({
    declarations:[LoginComponent,RegisterComponent],
    imports:[
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        MaterialModule,
        LoginRoutingModule,
        
    ]
   
})




export class LoginModule {}