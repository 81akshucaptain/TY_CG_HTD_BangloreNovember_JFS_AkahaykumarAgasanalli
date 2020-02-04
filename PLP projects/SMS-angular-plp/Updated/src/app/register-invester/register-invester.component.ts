import { Component, OnInit } from '@angular/core';
import { InvesterServicesService } from '../invester-services.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register-invester',
  templateUrl: './register-invester.component.html',
  styleUrls: ['./register-invester.component.css']
})
export class RegisterInvesterComponent implements OnInit {
  error: string;
  message: string;
  investerDefaultEmail;
  constructor(
    private investerServices: InvesterServicesService,
    private router: Router
  ) {
    this.investerDefaultEmail = investerServices.investerEmailDefualt;
  }

  registerInvester(form: NgForm) {
    this.investerServices.registerInvester(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'invester Added Succesfully') {
        this.message = response.message;
        setTimeout(() => {
          this.message = null;
        }, 3000);
        this.router.navigateByUrl('/invester-home');
      } else {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
    });
    form.reset();
  }

  ngOnInit() {
  }

}
