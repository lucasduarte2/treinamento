import { Component, OnInit, Input } from '@angular/core';
import { Category } from 'src/app/core/entity/Category';

@Component({
  selector: 'stf-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.sass']
})
export class CategoryListComponent implements OnInit {

  @Input('categoryList')
  categoryList:Array<Category>

  constructor() { }

  ngOnInit() {
  }

}
