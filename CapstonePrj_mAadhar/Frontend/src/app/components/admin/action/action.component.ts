import { AdminService } from './../../../services/admin/admin.service';
import { Customers } from './../../../model/customers';
import { Application } from './../../../model/Application';
import { AdminRestService } from './../../../services/admin/admin-rest.service';
import { Component, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.css']
})
export class ActionComponent implements OnInit {

  applicationList:Application[]=[];
  customer!:Customers;
  isCust :boolean = false;
  appliedList:Application[]=[];
  isAppliedListEmpty:boolean = false;

  constructor(private adminRestService:AdminRestService,private adminService:AdminService) { }

  ngOnInit(): void {
    this.checkEmptyList();
  }

  checkEmptyList(){
    if(this.appliedList.length===0)
      this.isAppliedListEmpty = true;
  }

  getAllApplicationList(){
    this.applicationList.splice(0);
    this.adminRestService.getAllApplicationList().subscribe((res)=>{
      console.log(res);
      this.applicationList = res;
      //console.log(this.applicationList);
      this.getAppliedList();
    });
  }

  getAppliedList(){
    this.applicationList.forEach((appl,index)=>{
      if(appl.status==='Applied')
        this.appliedList.push(appl);
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

  acceptAppl(application:Application){
    console.log("Accept called");
    this.adminRestService.acceptAppl(application.custId).subscribe((res)=>{
      console.log(res);
      
    });
  }

  rejectAppl(application:Application){
    console.log("Reject called");
    this.adminRestService.rejectAppl(application.custId).subscribe((res)=>{
      console.log(res);
      
    });
  }

  logout(){
    console.log("logged out called");
    this.adminService.logout();
  }
}
