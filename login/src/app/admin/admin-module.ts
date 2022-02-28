import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "../shared/material/material.module";
import { AdminRoutingModule } from "./admin-routing.module";
import { BooksnewComponent } from "./entity/booksnew/booksnew.component";
import { BooksreadingComponent } from "./entity/booksreading/booksreading.component";
import { EditProfilComponent } from "./entity/edit-profil/edit-profil.component";

import { HeaderComponent } from "./header/header.component";
import { LayoutComponent } from "./layout.component";
import { SidenavComponent } from "./sidenav/sidenav.component";


@NgModule({
    declarations: [

        SidenavComponent,
        LayoutComponent,
        HeaderComponent,
        BooksnewComponent,
        BooksreadingComponent,
        EditProfilComponent,
        
        
    ]
    ,
    imports: [
        CommonModule,
        AdminRoutingModule,
        MaterialModule,
        FormsModule,
        ReactiveFormsModule
    ]
})


export class AdminModule { }