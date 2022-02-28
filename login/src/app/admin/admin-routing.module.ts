import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UserRouteAccessGuard } from "../core/user-route-access.guard";
import { Lavozim } from "../shared/model/Lavozim";
import { BadiiyComponent } from "./entity/badiiy/badiiy.component";
import { BooksnewComponent } from "./entity/booksnew/booksnew.component";
import { BooksreadingComponent } from "./entity/booksreading/booksreading.component";
import { EditProfilComponent } from "./entity/edit-profil/edit-profil.component";
import { FantastikComponent } from "./entity/fantastik/fantastik.component";
import { FileUploadComponent } from "./entity/file-upload/file-upload.component";

import { JahonAdabiyotiComponent } from "./entity/jahon-adabiyoti/jahon-adabiyoti.component";
import { KopuqilganComponent } from "./entity/kopuqilgan/kopuqilgan.component";
import { MaktabDarslariComponent } from "./entity/maktab-darslari/maktab-darslari.component";
import { MashhurlarHayotiComponent } from "./entity/mashhurlar-hayoti/mashhurlar-hayoti.component";
import { TarixiyComponent } from "./entity/tarixiy/tarixiy.component";
import { UserComponent } from "./entity/user/user.component";
import { LayoutComponent } from "./layout.component";

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: "booksnew"
      },
      {
        path: 'user',
        component: UserComponent,
        canActivate: [UserRouteAccessGuard],
        data: {
          authorities: [Lavozim.ADMIN, Lavozim.DIREKTOR]
        }
      },
      { path: 'booksnew', component: BooksnewComponent },
      { path: 'bookreding', component: BooksreadingComponent },
      { path: 'kopuqilgan', component: KopuqilganComponent },
      { path: 'badiiy', component: BadiiyComponent },
      { path: 'tarixiy', component: TarixiyComponent },
      { path: 'fantastik', component: FantastikComponent },
      { path: 'jahon', component: JahonAdabiyotiComponent },
      { path: 'maktab', component: MaktabDarslariComponent },
      { path: 'mash', component: MashhurlarHayotiComponent },
      {path: "file" ,component:FileUploadComponent} ,

      { path: "edit", component: EditProfilComponent },
    ],
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})












export class AdminRoutingModule { }