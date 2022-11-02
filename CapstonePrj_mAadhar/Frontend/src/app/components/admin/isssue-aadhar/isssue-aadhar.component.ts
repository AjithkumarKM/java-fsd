import {  Router, Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-isssue-aadhar',
  templateUrl: './isssue-aadhar.component.html',
  styleUrls: ['./isssue-aadhar.component.css']
})
export class IsssueAadharComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  gotoAdminLoginPage(){
    this.router.navigate(['adminLogin']);
  }

  gotoCustomerLoginPage(){
    this.router.navigate(['customerLogin']);
  }

  gotoCustomerREgisterPage(){
    this.router.navigate(['cutomerRegister']);
  }
}
