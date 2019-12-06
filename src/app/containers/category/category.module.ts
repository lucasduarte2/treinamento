import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryListComponent } from './category-list/category-list.component';
import { BaseMaterialModule } from 'src/app/core/config/sabe-material.module';
import { CategoryDetailComponent } from './category-detail/category-detail.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [CategoryListComponent, CategoryDetailComponent],
  imports: [
    CommonModule,
    BaseMaterialModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [CategoryListComponent, CategoryDetailComponent]
})
export class CategoryModule { }
