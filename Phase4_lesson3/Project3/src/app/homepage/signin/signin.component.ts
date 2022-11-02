import { SignupService } from 'src/app/services/signup.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private signupService: SignupService,private router: Router) { }

  ngOnInit() {
  }

  submit(userForm:any){
    if(this.signupService.checkCredentials(userForm.value.email,userForm.value.password)){
      this.router.navigate(['']);
    }
  }
}
