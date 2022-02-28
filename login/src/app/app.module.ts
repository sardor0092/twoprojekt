import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './shared/shared.module';
import { UserComponent } from './admin/entity/user/user.component';
import { CoreModule } from './core/core-module';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
import { AuthInterceptor } from './shared/auth-interceptor';
import { DeleredialogComponent } from './deleredialog/deleredialog.component';
import { KopuqilganComponent } from './admin/entity/kopuqilgan/kopuqilgan.component';
import { BadiiyComponent } from './admin/entity/badiiy/badiiy.component';
import { TarixiyComponent } from './admin/entity/tarixiy/tarixiy.component';
import { FantastikComponent } from './admin/entity/fantastik/fantastik.component';
import { JahonAdabiyotiComponent } from './admin/entity/jahon-adabiyoti/jahon-adabiyoti.component';
import { MaktabDarslariComponent } from './admin/entity/maktab-darslari/maktab-darslari.component';
import { MashhurlarHayotiComponent } from './admin/entity/mashhurlar-hayoti/mashhurlar-hayoti.component';
import { FileUploadComponent } from './admin/entity/file-upload/file-upload.component';



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    DeleredialogComponent,
    KopuqilganComponent,
    BadiiyComponent,
    TarixiyComponent,
    FantastikComponent,
    JahonAdabiyotiComponent,
    MaktabDarslariComponent,
    MashhurlarHayotiComponent,
    FileUploadComponent,
    FileUploadComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MaterialModule,
    CoreModule,
    SharedModule,


  ],



  providers: [


    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' }
    },
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true,

    }
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
