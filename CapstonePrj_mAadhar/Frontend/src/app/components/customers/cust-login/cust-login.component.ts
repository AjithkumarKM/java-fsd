import { Router } from '@angular/router';
import { CustomersRestService } from './../../../services/customers/customers-rest.service';
import { CustomersService } from './../../../services/customers/customers.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cust-login',
  templateUrl: './cust-login.component.html',
  styleUrls: ['./cust-login.component.css']
})
export class CustLoginComponent implements OnInit {

  customerLoginForm = new FormGroup({
    cid : new FormControl(),
    password :  new FormControl()
  })

  constructor(private customersService:CustomersService, private customersRestService:CustomersRestService,private router:Router) { }

  ngOnInit(): void {
  }

  loginFunc(){
    let password = this.customerLoginForm.value.password;
    let cid = this.customerLoginForm.value.cid;
    this.customersRestService.login(cid,password).subscribe((res)=>{
      console.log(res);
      if(res){
        sessionStorage.setItem("user",cid);
        this.router.navigate(['customerAction']);
      }
      
    });
    // let passArray : string[] = [...password];
    // let isValid : boolean = true;
    
    // passArray.forEach((number,index)=>{
    //   if(!(+number>0 || +number<9))
    //     isValid = false;
    // })

    // if(!isValid){
    //   alert('Password should contain only numbers ')
    // }

  }
}
