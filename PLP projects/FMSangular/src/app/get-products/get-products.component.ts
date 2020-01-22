import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-products',
  templateUrl: './get-products.component.html',
  styleUrls: ['./get-products.component.css']
})
export class GetProductsComponent implements OnInit {
  products: Products[];
  message: string;

  constructor(
    private adminService: AdminService,
    private router: Router
  ) {
    this.getProducts();

  }
  getProducts() {
    this.adminService.viewProduct().subscribe(response => {
      console.log(response);
      this.products = response.product;
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
