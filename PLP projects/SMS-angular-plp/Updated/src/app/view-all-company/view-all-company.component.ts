import { Component, OnInit } from '@angular/core';
import { ManagerService } from '../manager.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-company',
  templateUrl: './view-all-company.component.html',
  styleUrls: ['./view-all-company.component.css']
})
export class ViewAllCompanyComponent implements OnInit {
  message: string;
  companies: Company[];
  constructor(private managerService: ManagerService,
  ) {
    this.viewAllCompanies();
  }



  viewAllCompanies() {
    this.managerService.viewCompany().subscribe(response => {
      console.log(response);
      this.companies = response.companies;
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
