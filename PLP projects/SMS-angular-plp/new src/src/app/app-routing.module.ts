import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InvesterHomeComponent } from './invester-home/invester-home.component';
import { UpdateInvesterComponent } from './update-invester/update-invester.component';
import { LoginInvesterComponent } from './login-invester/login-invester.component';
import { NgModel } from '@angular/forms';
import { RegisterInvesterComponent } from './register-invester/register-invester.component';
import { ViewAllCompanyComponent } from './view-all-company/view-all-company.component';
import { ViewAllStockinfoComponent } from './view-all-stockinfo/view-all-stockinfo.component';
import { ViewStocksComponent } from './view-stocks/view-stocks.component';
import { PurchaseStocksComponent } from './purchase-stocks/purchase-stocks.component';


const routes: Routes = [
  { path: 'login-invester', component: LoginInvesterComponent },
  { path: 'invester-home', component: InvesterHomeComponent },
  { path: 'update-invester/:investerID', component: UpdateInvesterComponent },
  { path: 'register-invester', component: RegisterInvesterComponent },
  { path: 'view-all-company', component: ViewAllCompanyComponent },
  { path: 'view-all-invester-stock-info', component: ViewAllStockinfoComponent },
  { path: 'view-all-stocks', component: ViewStocksComponent },
  { path: 'purchase-stocks/:stockID', component: PurchaseStocksComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
