import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { InvesterServicesService } from '../invester-services.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-invester',
  templateUrl: './update-invester.component.html',
  styleUrls: ['./update-invester.component.css']
})
export class UpdateInvesterComponent implements OnInit {
  investerID1;
  investerName1;
  investerCity1;
  investerPhone1;
  investerEmail1;
  investerPostal1;

  constructor(
    private investerService: InvesterServicesService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe(data => {
      console.log(data.investerID);
      this.investerID1 = data.investerID;
    });

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.investerName1 = data.investerName;
      this.investerPhone1 = data.investerPhone;
      this.investerEmail1 = data.investerEmail;
      this.investerCity1 = data.investerCity;
      this.investerPostal1 = data.investerPostal;
    });
  }
  updateInvester(form: NgForm) {
    this.investerService.updateInvesterDetails(form.value).subscribe(res => {
      console.log(res);
      if (res.message === 'Success') {
        console.log('Invester Updated Successfuly');
        this.router.navigateByUrl('/invester-home');
      }
      form.reset();
    });
  }
  ngOnInit() {
  }

}
