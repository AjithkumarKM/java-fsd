import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-string-interpolation',
  templateUrl: './string-interpolation.component.html',
  styleUrls: ['./string-interpolation.component.scss']
})
export class StringInterpolationComponent implements OnInit {

  message = "This is from bindings";
  @Input() name! :string;

  //@Input() counter:number;
  //@Output() op:EventEmitter<number> = new EventEmitter<number>();
  @Output() op:EventEmitter<string> = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

 message1():string{
    return "This is called prperty binding";
  }
  onClick(){
    console.log("This is from click function - event Binding") ;
  }
  onEmit(operation:string){
    //operation === 'Inc'? this.counter++ : this.counter--
    //this.op.emit(this.counter);
    this.op.emit(operation);
    console.log(operation) ;
  }
}
