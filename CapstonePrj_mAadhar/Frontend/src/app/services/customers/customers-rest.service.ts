import { HttpClient } from '@angular/common/http';
import { Customers } from './../../model/customers';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomersRestService {

  constructor(private httpClient:HttpClient) { }

  registerCustomer(customer:Customers){
    console.log(customer);
    return this.httpClient.post<Customers>(`http://localhost:8080/customer/addCustomer`,customer);
  }

  login(cid:string , password:string){
    return this.httpClient.get<Customers>(`http://localhost:8080/customer/loginCustomer/${cid}/${password}`);
  }

  applyNewAppl(cid:string){
    console.log("rest called");
    return this.httpClient.post<any>(`http://localhost:8080/application/addNewApplication/${cid}`,null);
  }

  updateCustomer(customer: Customers){
    return this.httpClient.put<any>(`http://localhost:8080/customer/updateCustomer`,customer);
  }

  getId(){
    return this.httpClient.get<any>(`http://localhost:8080/customer/getMaxId`);
  }

  getAadhar(custId:number){
    return this.httpClient.get<Customers>(`http://localhost:8080/customer/findCustomerById/${custId}`);
  }
}
