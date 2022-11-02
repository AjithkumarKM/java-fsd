import { Router } from '@angular/router';
import { CustomersRestService } from './../../../services/customers/customers-rest.service';
import { Component, OnInit } from '@angular/core';
import { Customers } from 'src/app/model/customers';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cust-action',
  templateUrl: './cust-action.component.html',
  styleUrls: ['./cust-action.component.css']
})
export class CustActionComponent implements OnInit {

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

  customer!:Customers;
  isCust :boolean = false;

  constructor(private customersRestService:CustomersRestService,private router:Router) { }

  ngOnInit(): void {
  }

  applyNewCard(){
    console.log("funstion called");
    // let user:any = JSON.parse(localStorage.getItem('currentUser') || '{}');
    // console.log(typeof(user));

    const data = sessionStorage.getItem("user");
    let historyArr ;
    if (data) {
      historyArr = JSON.parse(data);
    }
     console.log(historyArr);
     console.log(typeof(historyArr));
    let strUser = historyArr.toString();
    console.log(typeof(strUser));

    this.customersRestService.applyNewAppl(strUser).subscribe((res)=>{
      console.log(res);
      if(res)
      {
        alert('Your application has been submitted successfully');
      }
      else{
        alert('Your application has nnot been submitted');
      }
    });
  }

  updateCustomer(){
    console.log(this.customerForm.value.gender);
    console.log(this.customerForm.value.dob);
    console.log(this.customerForm.value.name);
    // console.log(this.customerForm.value.email);
    // console.log(this.customerForm.value.phone);
    // console.log(this.customerForm.value.pincode);
    // console.log(this.customerForm.value.addressLine);
    
    this.newCustomer.custId = 1001;
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
    this.customersRestService.updateCustomer(this.newCustomer).subscribe((res)=>{
      console.log(res);
    });
  }

  getAadhar(){
    const data = sessionStorage.getItem("user");
    let historyArr ;
    if (data) {
      historyArr = JSON.parse(data);
    }
     console.log(historyArr);
    // console.log(typeof(historyArr));
    let strUser = +historyArr;

    this.customersRestService.getAadhar(strUser).subscribe((res)=>{
      console.log(res);
      if(res){
        this.isCust=true;
        this.customer = res;
      }
      else{
        console.log("Not able to fetch Details!! Try again");
        
      }
    });
  }

  hideDetails(){
    this.isCust=false;
  }

  logout(){
    sessionStorage.removeItem('user');
    alert('Successfully logged out');
    this.router.navigate(['']);
  }

  
}
