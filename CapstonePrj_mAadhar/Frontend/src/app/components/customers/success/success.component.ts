import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  strUser:string='';

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    const data = sessionStorage.getItem("user");
    let historyArr ;
    if (data) {
      historyArr = JSON.parse(data);
    }
     console.log(historyArr);
     console.log(typeof(historyArr));
     this.strUser = historyArr.toString();
  }

  home(){
    sessionStorage.removeItem('user');
    this.router.navigate(['']);
  }

}
