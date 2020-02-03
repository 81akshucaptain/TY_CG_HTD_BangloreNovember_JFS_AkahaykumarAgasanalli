import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule, NgModel } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InvesterHomeComponent } from './invester-home/invester-home.component';
import { UpdateInvesterComponent } from './update-invester/update-invester.component';
import { LoginInvesterComponent } from './login-invester/login-invester.component';
import { RegisterInvesterComponent } from './register-invester/register-invester.component';
import { ViewAllCompanyComponent } from './view-all-company/view-all-company.component';
import { ViewAllStockinfoComponent } from './view-all-stockinfo/view-all-stockinfo.component';
import { ViewStocksComponent } from './view-stocks/view-stocks.component';

@NgModule({
  declarations: [
    AppComponent,
    InvesterHomeComponent,
    UpdateInvesterComponent,
    LoginInvesterComponent,
    RegisterInvesterComponent,
    ViewAllCompanyComponent,
    ViewAllStockinfoComponent,
    ViewStocksComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
