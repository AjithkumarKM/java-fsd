import { RouterGuardService } from './services/router-guard.service';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './homepage/about-us/about-us.component';
import { ContactusComponent } from './homepage/contactus/contactus/contactus.component';
import { HomepageComponent } from './homepage/homepage.component';
import { SigninComponent } from './homepage/signin/signin.component';
import { SignupComponent } from './homepage/signup/signup.component';
import { LogoutComponent } from './homepage/logout/logout.component';

const routes: Routes = [
  { path:'' ,component:HomepageComponent},
  { path:'signin',component:SigninComponent },
  { path:'signup',component:SignupComponent },
  { path:'aboutus',component:AboutUsComponent,canActivate:[RouterGuardService] },
  { path:'logout',component:LogoutComponent,canActivate:[RouterGuardService ]},
  { path:'contactus',component:ContactusComponent,canActivate:[RouterGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
