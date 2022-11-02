import { Router } from '@angular/router';
import { CustomersRestService } from './../../../services/customers/customers-rest.service';
import { Customers } from './../../../model/customers';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cust-register',
  templateUrl: './cust-register.component.html',
  styleUrls: ['./cust-register.component.css']
})
export class CustRegisterComponent implements OnInit {

  static custId:number;

  newCustomer = new Customers();

  customerForm = new FormGroup({
    name : new FormControl(),
    email : new FormControl(),
    gender : new FormControl(),
    addressLine : new FormControl(),
    city : new FormControl(),
    district : new FormControl(),
    state : new FormControl(),
    pincode : new FormControl(),
    phone : new FormControl(),
    dob : new FormControl()
  })

  constructor(private  customersRestService:CustomersRestService,private router:Router) { }

  ngOnInit(): void {
    this.getMaxId();
  }

  registerCustomer(){
    console.log(this.customerForm.value.gender);
    console.log(this.customerForm.value.dob);
    console.log(this.customerForm.value.name);
    // console.log(this.customerForm.value.email);
    // console.log(this.customerForm.value.phone);
    // console.log(this.customerForm.value.pincode);
    // console.log(this.customerForm.value.addressLine);
    
    this.newCustomer.custId = CustRegisterComponent.custId;
    this.newCustomer.name = this.customerForm.value.name;
    this.newCustomer.email = this.customerForm.value.email;
    this.newCustomer.gender = this.customerForm.value.gender;
    this.newCustomer.addressLine = this.customerForm.value.addressLine;
    this.newCustomer.city = this.customerForm.value.city;
    this.newCustomer.district = this.customerForm.value.district;
    this.newCustomer.state = this.customerForm.value.state;
    this.newCustomer.pincode = this.customerForm.value.pincode;
    this.newCustomer.dob = this.customerForm.value.dob;
    this.newCustomer.phoneNo = this.customerForm.value.phone;

    console.log(this.newCustomer);
    this.customersRestService.registerCustomer(this.newCustomer).subscribe((res)=>{
      console.log(res);
      if(res){
        this.router.navigate(['customerSuccess']);
        sessionStorage.setItem('user',CustRegisterComponent.custId.toString());
        CustRegisterComponent.custId += 1;
      }
      else{
        alert("Unable To register, Try again!!");
      }
    });
  }

  getMaxId(){
    this.customersRestService.getId().subscribe((res)=>{
      CustRegisterComponent.custId = res+1;
      console.log(CustRegisterComponent.custId);
      
    });
  }
}
