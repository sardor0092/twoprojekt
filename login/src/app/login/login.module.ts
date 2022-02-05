import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/shared/material/material.module";
import { LoginComponent } from "./login.component";
import { RegisterComponent } from "./register/RegisterComponent";

@NgModule({
    declarations:[RegisterComponent,LoginComponent],
    imports:[
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        MaterialModule,
        
    ]
   
})




export class LoginModule {}