import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SigninComponent } from './components/signin/signin.component';
import { LogoutComponent } from './components/logout/logout.component';

const routes: Routes = [
  { path:'',component:HomeComponent },
  { path:'home',component:HomeComponent },
  { path:'login',component:LoginComponent },
  { path:'signin',component:SigninComponent },
  { path:'logout',component:LogoutComponent },
  { path:'**',component:HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
