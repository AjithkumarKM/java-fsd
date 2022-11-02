import { Router } from '@angular/router';
import { AdminRestService } from './../../../services/admin/admin-rest.service';
import { AdminService } from './../../../services/admin/admin.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  adminLogin = new FormGroup({
    username : new FormControl(),
    password : new FormControl()
  });

  hashSym = '%23';
  atSym = '%40';
  exclaSym = '%21';
  dollarSym = '%24';
  percentSym = '%25';
  andSym = '%26';
  starSym = '%2A';

  constructor(private adminRestService:AdminRestService,private router:Router) { }

  ngOnInit(): void {
  }

  loginFunc(){
    const username :string = this.adminLogin.value.username;
    const password :string = this.adminLogin.value.password;
    const changedPass :string[] = [...password] ;
    let newPassword: string ='';

    changedPass.forEach((char,index)=>{
      if(char==='#')
        newPassword += this.hashSym;
      else if(char==='@')
        newPassword += this.atSym;
      else if(char==='!')
        newPassword += this.exclaSym;
      else if(char==='$')
        newPassword += this.dollarSym;
      else if(char==='&')
        newPassword += this.andSym;
      else if(char==='%')
        newPassword += this.percentSym;
      else if(char==='*')
        newPassword += this.starSym;
      else
        newPassword += char;
    })

    //console.log(this.adminLogin.value.username);
    //console.log(this.adminLogin.value.password);
    console.log(newPassword);
    console.log(typeof(newPassword));
    this.adminRestService.login(username,newPassword).subscribe((res)=>{
      console.log(res);
      if(!res){
        alert("Wrong Credentiasl !! Try again")
      }
      else{
        sessionStorage.setItem('admin',username);
        this.router.navigate(['adminAction']);
      }
    });
  }
}
