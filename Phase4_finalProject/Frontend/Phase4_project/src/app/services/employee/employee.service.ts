import { Employee } from './../../model/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient:HttpClient) { }

  getDetails(){
    return this.httpClient.get<Employee[]>('http://localhost:8080/employee/getAllEmployee');
  }

  deleteEmployee(employee:Employee){
    return this.httpClient.delete(`http://localhost:8080/employee/deleteEmployeeById/${employee.id}`);
  }

  addEmployee(employee : Employee){
    return this.httpClient.post<Employee>(`http://localhost:8080/employee/addEmployee`,employee);
  }

  editEmployee(employee:Employee){
    console.log("updating http");
    
    return this.httpClient.put<Employee>(`http://localhost:8080/employee/updateEmployee`,employee);
  }

  getById(id:any){
    return this.httpClient.get<Employee>(`http://localhost:8080/employee/getEmployeeById/${id}`);
  }
}
