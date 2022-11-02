import { Admin } from 'src/app/model/admin';
import { AdminService } from './../../../services/admin/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeComponent } from '../../employee/employee/employee.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  loginForm = new FormGroup({
    email : new FormControl('',Validators.required),
    password : new FormControl('',Validators.required)
  })

  adminList:Admin[]=[];

  constructor(private adminService: AdminService,private router:Router) { }

  ngOnInit(): void {
    this.adminList = this.adminService.getAdmins();
  }

  validateLogin(){
    this.adminService.validateLogin(this.loginForm.value.email,this.loginForm.value.password);
    console.log(this.loginForm.value);
    console.log(this.adminService.isLoggedIn());
  }
}
