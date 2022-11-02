import { AdminService } from './../../../services/admin/admin.service';
import { Admin } from './../../../model/admin';
import { AdminRestService } from './../../../services/admin/admin-rest.service';
import { Component, OnInit } from '@angular/core';
import { Application } from 'src/app/model/Application';
import { Customers } from 'src/app/model/customers';

@Component({
  selector: 'app-duplicate-aadhar',
  templateUrl: './duplicate-aadhar.component.html',
  styleUrls: ['./duplicate-aadhar.component.css']
})
export class DuplicateAadharComponent implements OnInit {

  applicationList:Application[]=[];
  issuedList:Application[]=[];
  customer!:Customers;
  isCust :boolean = false;

  constructor(private adminRestService:AdminRestService,private adminService:AdminService) { }

  ngOnInit(): void {
    this.getAllApplicationList();
  }

  getAllApplicationList(){
    this.applicationList.splice(0);
    this.adminRestService.getAllApplicationList().subscribe((res)=>{
      console.log(res);
      this.applicationList = res;
      //console.log(this.applicationList);
      this.getIssueddList();
    });
  }

  getIssueddList(){
    this.applicationList.forEach((appl,index)=>{
      if(appl.status==='Accepted')
        this.issuedList.push(appl);
    })
  }

  getCustomerDetails(application:Application){
    this.adminRestService.findCustomerById(application.custId).subscribe((res)=>{
      console.log(res);
      this.isCust=true;
      this.customer = res;
    });
  }

  hideDetails(){
    this.isCust=false;
  }

  deleteAppl(application:Application){
    this.adminRestService.deleteCustomer(application.custId).subscribe((res)=>{
      console.log(res);
      if(res){
        alert("Customer has been successfullu deleted");
      }
      else{
        alert("Customer has not been deleted!!");
      }
    });
    this.adminRestService.deleteFromApplList(application.custId).subscribe((res)=>{
      console.log(res);
    })
  }

  logout(){
    this.adminService.logout();
  }
}
