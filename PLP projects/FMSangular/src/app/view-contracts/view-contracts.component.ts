import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-contracts',
  templateUrl: './view-contracts.component.html',
  styleUrls: ['./view-contracts.component.css']
})
export class ViewContractsComponent implements OnInit {
  contracts: Contracts;

  constructor(
    private adminService: AdminService,
    private router: Router,
  ) {
    this.getContracts();
  }
  getContracts() {
    this.adminService.viewContracts().subscribe(response => {
      console.log(response);
      this.contracts = response.contract;
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}

