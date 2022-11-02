import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  adminList: Admin[] = [
    {
      email: "admin1",
      password: "admin@123"
    },
    {
      email: "admin2",
      password: "admin234#"
    }
  ];

  constructor(private router: Router) { }

  getAdmins(): Admin[] {
    return this.adminList;
  }

  validateLogin(email: any, password: any) {
    let thisAdmin: any = this.adminList.find((admin) => {
      if (admin.email === email && admin.password === password) {
        return admin;
      }
      return null;
    })
    if (thisAdmin == undefined) {
      alert('Check credentials! Try again!!');
      return false;
    }
    else {
      console.log(thisAdmin);
      sessionStorage.setItem('user', thisAdmin.email);
      this.router.navigate(['employee']);
    }
    return true;
  }

  isLoggedIn() {
    let user = sessionStorage.getItem('user');
    return !(user === null);
  }

  changePassword(newPassword: any) {
    let user = sessionStorage.getItem('user');
    //console.log(this.adminList);
    const newArr = this.adminList.findIndex(admin => {
      return (admin.email === user);
    });
    if(newArr!==-1){
      this.adminList[newArr].password=newPassword;
      alert('Password changed successfully!');
    }
    console.log(this.adminList);
  }

  logout(){
    sessionStorage.removeItem('user');
    alert('You have logged out successfully');
    this.router.navigate(['']);
  }
}
