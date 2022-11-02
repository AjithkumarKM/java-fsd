import { SigninUser } from './../../interface/signin';

import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/services/signin.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private signinService : SigninService){

  }

  ngOnInit(): void {
  }

  addUser(userForm:any){
    // this.signinService.addUser(userForm);
    console.log(userForm.value);
  }

}
