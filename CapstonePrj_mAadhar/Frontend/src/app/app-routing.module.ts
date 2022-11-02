import { AdminGuardService } from './services/admin-guard.service';
import { LoginComponent } from './components/admin/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/admin/register/register.component';
import { ActionComponent } from './components/admin/action/action.component';
import { CustRegisterComponent } from './components/customers/cust-register/cust-register.component';
import { CustLoginComponent } from './components/customers/cust-login/cust-login.component';
import { CustActionComponent } from './components/customers/cust-action/cust-action.component';
import { IsssueAadharComponent } from './components/admin/isssue-aadhar/isssue-aadhar.component';
import { DuplicateAadharComponent } from './components/admin/duplicate-aadhar/duplicate-aadhar.component';
import { RouterGuardService } from './services/router-guard.service';
import { SuccessComponent } from './components/customers/success/success.component';

const routes: Routes = [
  { path:"",component:IsssueAadharComponent },
  { path:"adminLogin",component:LoginComponent},
  { path:"adminRegister",component:RegisterComponent },
  { path:"adminAction" ,component:ActionComponent,canActivate:[AdminGuardService]},
  { path:"cutomerRegister",component:CustRegisterComponent },
  { path:"customerLogin",component:CustLoginComponent },
  { path:"customerAction",component:CustActionComponent , canActivate:[RouterGuardService]},
  { path:'getIssuedList',component:DuplicateAadharComponent ,canActivate:[AdminGuardService]},
  { path:'customerSuccess',component:SuccessComponent ,canActivate:[RouterGuardService]},
  { path:'**',component:IsssueAadharComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
