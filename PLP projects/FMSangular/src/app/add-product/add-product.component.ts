import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  error: string;
  message: string;
  constructor(
    private auth: AdminService,
    private router: Router) { }

  addProduct(form: NgForm) {
    console.log(form.value);

    this.auth.addProduct(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'Product Added Succesfully') {
        this.message = response.message;
        setTimeout(() => {
          this.message = null;
        }, 3000);
      } else {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
      form.reset();
    });
  }

  ngOnInit() {
  }

}
