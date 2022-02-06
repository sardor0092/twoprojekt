import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UserRouteAccessGuard } from "../core/user-route-access.guard";
import { Lavozim } from "../shared/model/Lavozim";
import { BooksnewComponent } from "./entity/booksnew/booksnew.component";
import { BooksreadingComponent } from "./entity/booksreading/booksreading.component";
import { EditProfilComponent } from "./entity/edit-profil/edit-profil.component";
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

      { path: "edit", component: EditProfilComponent },
    ],
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})












export class AdminRoutingModule { }