import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-contracts',
  templateUrl: './get-contracts.component.html',
  styleUrls: ['./get-contracts.component.css']
})
export class GetContractsComponent implements OnInit {
  contracts: Contracts[];
  message: string;

  constructor(
    private customerService: CustomerService,
    private router: Router
  ) {
    this.getContractsById();

  }
  getContractsById() {
    this.customerService.viewContractById().subscribe(response => {
      console.log(response);
      this.contracts = response.contract;
    }, err => {
      console.log(err);
    });
  }


  deleteContracts(contract: Contracts) {
    this.customerService.deleteContract(contract).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        this.contracts.splice(this.contracts.indexOf(contract), 1);
        this.message = res.message;
      }
    });
  }

  deleteMessage() {
    this.message = this.message;
  }

  selectedContract(contractBean) {
    // this.customerService.selectedContractToUpdate = customerBean;
    // console.log(this.customerService.selectedContractToUpdate);
    this.router.navigate([`/update-contract/${contractBean.contractId}`],
      {
        queryParams: {
           customerId: contractBean.customerId,
          productId: contractBean.productId, haulierId: contractBean.haulierId,
          deliveryDate: contractBean.deliveryDate, qunatity: contractBean.qunatity
        }
      }
    );
  }
  ngOnInit() {
  }

}
