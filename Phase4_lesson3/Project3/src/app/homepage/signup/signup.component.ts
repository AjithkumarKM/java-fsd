import { Component, OnInit } from '@angular/core';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private signupService:SignupService) { }

  ngOnInit() {
  }

  submit(signinForm:any){
    console.log(signinForm.value);
    this.signupService.addUser(signinForm.value.email,signinForm.value.password);
  }
}
