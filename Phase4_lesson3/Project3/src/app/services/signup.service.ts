import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './signin';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  userList:User[] =[
    {
      email:'ajith@gmail.com',
      password:'thjia'
    }
  ];
  isUserPresent = false

  constructor(private router:Router) { }

  addUser(email:string,pwd:string){
    let newUser: User = {
      email : email,
      password: pwd
    }

    let isPresent:(User|undefined)= (this.userList.find((user)=>{
      return user.email === newUser.email;
      // newUser.email
    }))
    //console.log(isPresent);
    if(isPresent===undefined){
      console.log('Adding new user');
      this.userList.push(newUser);
      console.log(this.userList);
      alert('User is registered successfully');
    }
    else{
      alert('User is already registered');
    }
  }

  checkCredentials(email:string,pwd:string){
    let newUser: User = {
      email : email,
      password: pwd
    }
    let isPresent:(User|undefined)= (this.userList.find((user)=>{
      return (user.email === newUser.email && user.password===newUser.password);
      // newUser.email
    }))
    if(isPresent===undefined){
      alert('User is not registered, Please register!!');
      this.router.navigate(['signup']);
      return false;
    }
    else{
      alert('sigined successfully');
      sessionStorage.setItem('user',newUser.email);
      console.log(sessionStorage.getItem('user'));
      return true;
    }
  }

  isSignedIn(){
    let user = sessionStorage.getItem('user')
    return !(user === null)
  }

  logout(){
    sessionStorage.removeItem('user');
    alert('logged out successfully');
  }
}
