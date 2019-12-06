import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '@angular/forms';
import { CategoryService } from '../category.service';

@Component({
  selector: 'stf-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.sass']
})
export class CategoryDetailComponent implements OnInit {
  public categoryForm: FormGroup;

  @ViewChild('categoryFormModel', {static: false})
  public categoryFormModel: NgForm;

  constructor(private formBuilder: FormBuilder, private postCategory: CategoryService ) { }

  ngOnInit() {
    //this.formControlGroup = new FormGroup({
    //  nomeControl: new FormControl()
    //});

    this.categoryForm = this.formBuilder.group({
      nome: ['',[Validators.required, Validators.minLength(3)]],
    });
  }

  onSubmit() {
    if (!this.categoryForm.valid) {
      return;
    }
    console.log(this.categoryForm.value)
    this.postCategory.postCategory(this.categoryForm.value).subscribe(resp => {
      console.log(resp)
    });;
  }

  reset() {
    this.categoryFormModel.reset();
    this.categoryForm.reset( );
  }

}
