import { Component, OnInit } from '@angular/core';
import { Category } from './core/entity/Category';
import { CategoryService, CategoryServiceType } from './containers/category/category.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'stf-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})

export class AppComponent implements OnInit {
  appTitle = 'Money App';

  public categoryList: Array<Category> = new Array();

  public futuro: BehaviorSubject<CategoryServiceType> ;

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.futuro = this.categoryService.categoryBehaviorSubject;
    this.getCaregoryList();
  } 
  
  private getCaregoryList() {
   this.categoryService.getCategoryList();
  }

}