import { Component, OnInit } from '@angular/core';
import { InvesterServicesService } from '../invester-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-invester-home',
  templateUrl: './invester-home.component.html',
  styleUrls: ['./invester-home.component.css']
})
export class InvesterHomeComponent implements OnInit {
  investers: Investers[];
  message: string;
  email: string;
  constructor(
    private investerServices: InvesterServicesService,
    private router: Router
  ) {
    this.searchInvester();
    // this.alwayExecuteForGettingEmail();
  }
  selectedInvester(InvesterBean) {
    console.log(InvesterBean);
    this.router.navigate([`update-invester/${InvesterBean.investerID}`],
      {
        queryParams: {
          investerName: InvesterBean.investerName, investerEmail: InvesterBean.investerEmail,
          investerPhone: InvesterBean.investerPhone,
          investerPostal: InvesterBean.investerPostal,
          investerCity: InvesterBean.investerCity,
        }
      });
  }

  searchInvester() {
    const investerLoginDetails = JSON.parse(localStorage.getItem('investerLoginDetails'));
    console.log('This is investerLoginDetails converted');
    this.investerServices.investerEmailDefualt = investerLoginDetails.users[0].email;
    console.log('EMAIL IS :', this.investerServices.investerEmailDefualt);
    this.investerServices.searchInvester(this.investerServices.investerEmailDefualt).subscribe(response => {
      console.log(response);
      localStorage.setItem('investerDetails', JSON.stringify(response));
      console.log('Invester Details  are in local storage');
      const investerDetails = JSON.parse(localStorage.getItem('investerDetails'));
      console.log(investerDetails);
      this.investers = response.investers;
      console.log('Its Invester array deatails');

      console.log(this.investers);
    }, err => {
      console.log(err);
    });
  }

  // alwayExecuteForGettingEmail() {
  //   const investerLoginDetails = JSON.parse(localStorage.getItem('investerLoginDetails'));
  //   console.log('This is investerLoginDetails converted');
  //    = investerLoginDetails.users[0].email;
  //   console.log('EMAIL IS :', this.investerServices.investerEmailDefualt);
  // }

  isInvesterRegistered() {
    const investerDetails = JSON.parse(localStorage.getItem('investerDetails'));
    if (investerDetails.investers != null) {
      return true;
    } else {
      return false;
    }
  }
  ngOnInit() {
  }

}
