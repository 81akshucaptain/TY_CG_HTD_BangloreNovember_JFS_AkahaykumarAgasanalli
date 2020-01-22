import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { from } from 'rxjs';
import { HeaderComponent } from './header/header.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { FilteCustomerPipe } from './filte-customer.pipe';
import { FilterProductPipe } from './filter-product.pipe';
import { AddLandsComponent } from './add-lands/add-lands.component';
import { ViewLandsComponent } from './view-lands/view-lands.component';
import { UpdateLandsComponent } from './update-lands/update-lands.component';
import { FilterLandsPipe } from './filter-lands.pipe';
import { ViewContractsComponent } from './view-contracts/view-contracts.component';
import { FilterContractsPipe } from './filter-contracts.pipe';
import { AddContractComponent } from './add-contract/add-contract.component';
import { GetContractsComponent } from './get-contracts/get-contracts.component';
import { UpdateContractsComponent } from './update-contracts/update-contracts.component';
import { ScheduleContractsComponent } from './schedule-contracts/schedule-contracts.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { GetProductsComponent } from './get-products/get-products.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { SchedulerHomeComponent } from './scheduler-home/scheduler-home.component';
import { ViewContractsBySchedulerComponent } from './view-contracts-by-scheduler/view-contracts-by-scheduler.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    AddCustomerComponent,
    ViewCustomerComponent,
    UpdateCustomerComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    CustomerHomeComponent,
    AboutComponent,
    HomeComponent,
    ContactUsComponent,
    AddProductComponent,
    ViewProductComponent,
    UpdateProductComponent,
    FilteCustomerPipe,
    FilterProductPipe,
    AddLandsComponent,
    ViewLandsComponent,
    UpdateLandsComponent,
    FilterLandsPipe,
    ViewContractsComponent,
    FilterContractsPipe,
    AddContractComponent,
    GetContractsComponent,
    UpdateContractsComponent,
    ScheduleContractsComponent,
    UpdatePasswordComponent,
    GetProductsComponent,
    EditCustomerComponent,
    SchedulerHomeComponent,
    ViewContractsBySchedulerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
