import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  hashSym = '%23';
  atSym = '%40';
  exclaSym = '%21';
  dollarSym = '%24';
  percentSym = '%25';
  andSym = '%26';
  starSym = '%2A';

  constructor(private router:Router) { }

  validatePassword(password:string){
    const passArray :string[] = [...password] ;
    let capCount = 0;
    let smallCount = 0;
    let integerCount = 0;
    let specialSymCount = 0;

    passArray.forEach((ltr,index)=>{
      if(ltr>='a' && ltr<='z')
        smallCount++;
      else if(ltr>='A' && ltr<='Z')
        capCount++;
      else if(+ltr>=0 && +ltr<=9)
        integerCount++;
      else if(ltr==='!' || ltr==='@' || ltr==='#' || ltr==='$' || ltr==='%' || ltr==='&' || ltr==='*')
        specialSymCount++;
    });

    if(capCount===0 || smallCount===0 || specialSymCount ===0 || integerCount===0){
      console.log('Not valid');
      return false;
    }
    else{
      console.log('Vallid password');
      return true;
    }
  }  

  convertPassword(passArray:string[]){
    let newPassword: string ='';

    passArray.forEach((char,index)=>{
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

    return newPassword;
  }

  logout(){
    console.log("logged out service called");
    if(sessionStorage.getItem('admin')!==null){
      sessionStorage.removeItem('admin');
      alert('You have been successfully logged out');
      this.router.navigate(['']);
    }
    else{
      alert("Error ocurrs!! Try again");
    }
  }
}
