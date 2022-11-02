import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {

  hello = "HElo from input";
  counter = 0;
  constructor() { }

  ngOnInit(): void {
  }

  onOp(buttonType:string){
    buttonType === 'Inc'? this.counter++ : this.counter--;
  }
}
