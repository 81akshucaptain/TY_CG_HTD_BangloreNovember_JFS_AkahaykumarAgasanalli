import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-update-contracts',
  templateUrl: './update-contracts.component.html',
  styleUrls: ['./update-contracts.component.css']
})
export class UpdateContractsComponent implements OnInit {
  contractId1: number;
  customerId1: number;
  productId1: number;
  haulierId1: string;
  deliveryDate1: string;
  qunatity1: number;
  products: Products[];

  constructor(
    private customerService: CustomerService ,
    private adminService: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.getProducts();

    activatedRoute.params.subscribe(data => {
      console.log(data.contractId);
      this.contractId1 = data.contractId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.customerId1 = data.customerId;
      this.productId1 = data.productId;
      this.haulierId1 = data.haulierId;
      this.deliveryDate1 = data.deliveryDate;
      this.qunatity1 = data.qunatity;
    });
  }
  updateContract(form: NgForm) {
    this.customerService.updateContract(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('ContractUpdated Successfuly');
        this.router.navigateByUrl('/get-contracts');
      }
      form.reset();
    });
  }
  getProducts() {
    this.adminService.viewProduct().subscribe(response => {
      this.products = response.product;
      console.log(this.products);
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}

