import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rest',
  templateUrl: './rest.component.html',
  styleUrls: ['./rest.component.scss']
})
export class RestComponent implements OnInit {

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    
  }

  getWelcomeMessage(){
    this.getMsg();
  }

  getMsg(){
    console.log(this.httpClient.get('http://localhost:8080/msg'));
  }
}
