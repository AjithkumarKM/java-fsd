import { AdminService } from './../../../services/admin/admin.service';
import { FormGroup, FormControl, Validators, FormBuilder,} from '@angular/forms';
import { EmployeeService } from './../../../services/employee/employee.service';
import { Employee } from './../../../model/employee';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  newEmp = new Employee();
  empId:number=0;
  employeeList:Employee[]=[];
  employee !:FormGroup;  
  tempId:number=0;
  //tData: boolean = false;

  constructor(private employeeService:EmployeeService,private formBuilder:FormBuilder,private adminService:AdminService) { }

  ngOnInit(): void {
    this.getDetails();
    this.employee = this.formBuilder.group({
      name:[''],
      email:[''],
      designation:[''],
      salary:['']
    });
  }

  getDetails(){
    console.log('inside');
    //this.tData = true;
    this.employeeService.getDetails().subscribe(((employee)=>{
      console.log(employee);
      
      this.employeeList = employee;
      //this.employeeList = (...this.employeeList,employee)
    }))
  }

  deleteEmployee(employee: Employee){
    console.log(employee.id);
    //this.tData= false;
    this.employeeService.deleteEmployee(employee).subscribe((val)=>{
      console.log(val);
    });
    this.getDetails();
  }

  addEmployee(){
    //console.log(this.employee);
    //this.tData= false;
    this.newEmp.id = this.employee.value.id;
    this.newEmp.name = this.employee.value.name;
    this.newEmp.email = this.employee.value.email;
    this.newEmp.designation = this.employee.value.designation;
    this.newEmp.salary = this.employee.value.salary;
    //console.log(this.newEmp);
    this.employeeService.addEmployee(this.newEmp).subscribe((retVal)=>{
      console.log(retVal);
    });
    this.getDetails();
  }

  editEmployee(tempEmp:number){
    console.log(tempEmp);
    this.tempId = tempEmp;
  }

  updateEmployee(){
    console.log(this.employee);
    this.newEmp.id = this.tempId;
    this.newEmp.name = this.employee.value.name;
    this.newEmp.email = this.employee.value.email;
    this.newEmp.designation = this.employee.value.designation;
    this.newEmp.salary = this.employee.value.salary;
    console.log(this.newEmp);
    this.employeeService.editEmployee(this.newEmp).subscribe((vara)=>{
      console.log(vara);
      
    });
  }

  logout(){
    this.adminService.logout();
  }
}
