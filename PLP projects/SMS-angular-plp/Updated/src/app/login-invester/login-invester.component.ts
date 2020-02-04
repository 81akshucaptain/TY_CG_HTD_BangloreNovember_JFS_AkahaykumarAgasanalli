import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { InvesterServicesService } from '../invester-services.service';

@Component({
  selector: 'app-login-invester',
  templateUrl: './login-invester.component.html',
  styleUrls: ['./login-invester.component.css']
})
export class LoginInvesterComponent implements OnInit {
  error: string;
  constructor(
    private auth: InvesterServicesService,
    private router: Router) {
  }

  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(response => {
      console.log(response);
      if (response.message === 'Logged in') {
        localStorage.setItem('investerLoginDetails', JSON.stringify(response));
        console.log('investerLoginDetails are in local storage');
        this.router.navigateByUrl('/invester-home');
        // console.log(investerLoginDetails);

        // if (investerLoginDetails.users[0].userType === 'invester') {
        //   console.log('its userName', investerLoginDetails.users[0].userType);
      } else {
        this.error = response.message;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }

    });
  }

  ngOnInit() {
  }

}
