import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { from } from 'rxjs';
import { LateComersComponent } from './late-comers/late-comers.component';
import { HeaderComponent } from './header/header.component';
import { ProductsComponent } from './products/products.component';
import { ImagesComponent } from './images/images.component';
import { HomeComponent } from './home/home.component';
import { ColorDirective } from './color.directive';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikeDetailsComponent } from './bike-details/bike-details.component';

@NgModule({
  declarations: [
    AppComponent,
    DataBindingComponent,
    LateComersComponent,
    HeaderComponent,
    ProductsComponent,
    ImagesComponent,
    HomeComponent,
    ColorDirective,
    ParentComponent,
    ChildComponent,
    BikesComponent,
    BikeDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'lateComers', component: LateComersComponent},
      {path: 'product', component: ProductsComponent},
      {path: 'images', component: ImagesComponent},
      {path: 'parent', component: ParentComponent},
      {path: 'bikes', component: BikesComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
