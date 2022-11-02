import { Customers } from './../../model/customers';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Application } from 'src/app/model/Application';

@Injectable({
  providedIn: 'root'
})
export class AdminRestService {

  constructor(private httpClient:HttpClient) { }

  login(username:string, password:string){
    return this.httpClient.get(`http://localhost:8080/admin/getAdmin/${username}/${password}`);
  }

  addAdmin(username:string, password:string){
    return this.httpClient.post(`http://localhost:8080/admin/addAdmin/${username}/${password}`,null);
  }

  // updatePassword(username:string,password:string){
  //   return this.httpClient.post(`http://localhost:8080/admin/addAdmin/${username}/${password}`,null);
  // }

  getAllApplicationList(){
    return this.httpClient.get<Application[]>(`http://localhost:8080/application/getAllApplication`);
  }

  findCustomerById(custId:number){
    return this.httpClient.get<Customers>(`http://localhost:8080/customer/findCustomerById/${custId}`);
  }

  acceptAppl(custId:number){
    console.log('accept rest called');
    return this.httpClient.put<any>(`http://localhost:8080/application/acceptAppl/${custId}`,null);
  }

  rejectAppl(custId:number){
    console.log('Reject rest called');
    return this.httpClient.put<any>(`http://localhost:8080/application/rejectAppl/${custId}`,null);
  }

  deleteCustomer(custId:number){
    return this.httpClient.delete<any>(`http://localhost:8080/customer/deleteCustomer/${custId}`);
  }

  deleteFromApplList(custId:number){
    return this.httpClient.delete<any>(`http://localhost:8080/application/deleteApplication/${custId}`);
  }
}
