import { SignupService } from 'src/app/services/signup.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private signupService:SignupService) { }

  ngOnInit(): void {
  }

  logout(){
    this.signupService.logout();
  }
}
