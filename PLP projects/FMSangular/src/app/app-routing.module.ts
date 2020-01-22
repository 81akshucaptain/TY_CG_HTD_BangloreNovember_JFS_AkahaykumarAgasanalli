import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AboutComponent } from './about/about.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { AddLandsComponent } from './add-lands/add-lands.component';
import { UpdateLandsComponent } from './update-lands/update-lands.component';
import { ViewLandsComponent } from './view-lands/view-lands.component';
import { ViewContractsComponent } from './view-contracts/view-contracts.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { UpdateContractsComponent } from './update-contracts/update-contracts.component';
import { GetContractsComponent } from './get-contracts/get-contracts.component';
import { GetProductsComponent } from './get-products/get-products.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { SchedulerHomeComponent } from './scheduler-home/scheduler-home.component';
import { ScheduleContractsComponent } from './schedule-contracts/schedule-contracts.component';
import { ViewContractsBySchedulerComponent } from './view-contracts-by-scheduler/view-contracts-by-scheduler.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'contact', component: ContactUsComponent },
  { path: 'customer-home', component: CustomerHomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about', component: AboutComponent },
  { path: 'admin-home', component: AdminHomeComponent },
  { path: 'add-customers', component: AddCustomerComponent },
  { path: 'update-customer', component: UpdateCustomerComponent },
  { path: 'view-customers', component: ViewCustomerComponent },
  { path: 'add-products', component: AddProductComponent },
  { path: 'view-products', component: ViewProductComponent },
  { path: 'update-product', component: UpdateProductComponent },
  { path: 'add-lands', component: AddLandsComponent },
  { path: 'update-land', component: UpdateLandsComponent },
  { path: 'view-lands', component: ViewLandsComponent },
  { path: 'view-contracts', component: ViewContractsComponent },
  { path: 'add-contract', component: AddContractComponent },
  { path: 'get-contracts', component: GetContractsComponent },
  { path: 'update-contract', component: UpdateContractsComponent },
  {path: 'get-products', component: GetProductsComponent},
  {path: 'edit-customer', component: EditCustomerComponent},
  {path: 'scheduler-home', component: SchedulerHomeComponent},
  {path: 'schedule-contracts', component: ScheduleContractsComponent},
  {path: 'view-contract-by-scheduler', component: ViewContractsBySchedulerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
