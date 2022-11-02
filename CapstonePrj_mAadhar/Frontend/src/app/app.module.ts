import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header/header.component';
import { FooterComponent } from './components/footer/footer/footer.component';
import { LoginComponent } from './components/admin/login/login.component';
import { ActionComponent } from './components/admin/action/action.component';
import { IsssueAadharComponent } from './components/admin/isssue-aadhar/isssue-aadhar.component';
import { DuplicateAadharComponent } from './components/admin/duplicate-aadhar/duplicate-aadhar.component';
import { DeleteAadharComponent } from './components/admin/delete-aadhar/delete-aadhar.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/admin/register/register.component';
import { CustRegisterComponent } from './components/customers/cust-register/cust-register.component';
import { CustLoginComponent } from './components/customers/cust-login/cust-login.component';
import { CustActionComponent } from './components/customers/cust-action/cust-action.component';
import { SuccessComponent } from './components/customers/success/success.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    ActionComponent,
    IsssueAadharComponent,
    DuplicateAadharComponent,
    DeleteAadharComponent,
    RegisterComponent,
    CustRegisterComponent,
    CustLoginComponent,
    CustActionComponent,
    SuccessComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
