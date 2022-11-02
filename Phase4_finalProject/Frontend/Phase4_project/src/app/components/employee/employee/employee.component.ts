import { Employee } from './../../../model/employee';
import { EmployeeService } from './../../../services/employee/employee.service';
import { DetailsComponent } from './../details/details.component';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from './../../../services/admin/admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  isEmpfound=false;

  loginForm = new FormGroup({
    password: new FormControl('',Validators.required)
  })

  searchForm = new FormGroup({
    sid:new FormControl('',Validators.required)
  })

  constructor(private adminService:AdminService,private router:Router,private employeeService:EmployeeService) { }

  ngOnInit(): void {
  }

  changePassword(){
    console.log('new password ' + this.loginForm.value.password);
    this.adminService.changePassword(this.loginForm.value.password);
  }

  viewDetails(){
    this.router.navigate(['details']);
  }

  logout(){
    this.adminService.logout();
  }

  tempEmp = new Employee();
  getById(){
    this.employeeService.getById(this.searchForm.value.sid).subscribe((emp)=>{
      this.tempEmp.id =  emp.id;
      this.tempEmp.name =  emp.name;
      this.tempEmp.email =  emp.email;
      this.tempEmp.designation =  emp.designation;
      this.tempEmp.salary =  emp.salary;
    });
    if(this.tempEmp!=null){
      this.isEmpfound = true;
    }
  }
}
