import { AdminRestService } from './../../../services/admin/admin-rest.service';
import { AdminService } from './../../../services/admin/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  adminRegister = new FormGroup({
    username : new FormControl(),
    password : new FormControl()
  });

  constructor(private adminService:AdminService,private adminRestService:AdminRestService) { }

  ngOnInit(): void {
  }

  registerFunc(){
    //console.log(this.adminLogin.value.username);
    //console.log(this.adminLogin.value.password);

    const username :string = this.adminRegister.value.username;
    const password :string = this.adminRegister.value.password;
    const passArray :string[] = [...password] ;
    let newPassword: string ='';

    let isValid:boolean = this.adminService.validatePassword(password);
    if(isValid){
      newPassword = this.adminService.convertPassword(passArray);
      console.log(newPassword);
      this.adminRestService.addAdmin(username,newPassword).subscribe((res)=>{
        console.log(res);
      });
    }
    else{
      alert("Password must contain a UpperCase, LowerCase, Specail Character and digits!!");
    }

    // this.adminService.login(username,newPassword).subscribe((res)=>{
    //   console.log(res);
    // });
  }

}

