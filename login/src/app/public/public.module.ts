import { NgModule } from '@angular/core';
import { PublicRoutingModule } from './public-routing.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { HomeComponent } from './home/home.component';
import { CommonModule } from '@angular/common';
import { LayoutModule } from '@angular/cdk/layout';
import { LayoutComponent } from '../admin/layout.component';

@NgModule({
  declarations: [
    HomeComponent,
    
    
    
  ],
  imports: [
    CommonModule,
    PublicRoutingModule,
    MaterialModule,
    

  ],
  bootstrap: [HomeComponent]
})
export class PublicModule { }