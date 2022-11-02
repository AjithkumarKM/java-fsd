import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SigninService {

  user:SigninService[] = [];

  constructor() { }

  addUser(){
    this.user.push();
  }
}
