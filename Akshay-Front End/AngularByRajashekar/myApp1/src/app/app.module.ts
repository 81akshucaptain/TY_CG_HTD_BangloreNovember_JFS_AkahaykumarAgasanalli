import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule } from'@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SectionComponent } from './section/section.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AkshayComponent } from './akshay/akshay.component';
import { MownaComponent } from './mowna/mowna.component';
import { MallikComponent } from './mallik/mallik.component';
import { GallaryComponent } from './gallary/gallary.component';

@NgModule({
  declarations: [
    AppComponent,
    //importing the created Component name
    HeaderComponent,
    FooterComponent,
    SectionComponent,
    AboutComponent,
    RegisterComponent,
    ContactComponent,
    LoginComponent,
    HomeComponent,
    PageNotFoundComponent,
    AkshayComponent,
    MownaComponent,
    MallikComponent,
    GallaryComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'about', component:AboutComponent,children:[
        {path:'akshay',component:AkshayComponent},
        {path:'mowna',component:MownaComponent},
        {path:'mallik',component:MallikComponent}
      ]},
      {path: 'contact',component: ContactComponent},
      {path: 'register',component: RegisterComponent},
      {path: 'login',component: LoginComponent},
      {path:'gallary', component:GallaryComponent},
      {path:'**', component:PageNotFoundComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
