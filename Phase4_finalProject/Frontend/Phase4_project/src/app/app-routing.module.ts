import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin/admin.component';
import { DetailsComponent } from './components/employee/details/details.component';
import { EmployeeComponent } from './components/employee/employee/employee.component';
import { RouterGuardService } from './services/router-guard.service';

const routes: Routes = [
  { path:'',component:AdminComponent },
  { path:'employee',component:EmployeeComponent, canActivate:[RouterGuardService] },
  { path:'details',component:DetailsComponent , canActivate:[RouterGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
