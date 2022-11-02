//1.2 let and const are block scoped
let name="ajith";
console.log(name)

//cannot redeclare const variable
/*const name1="Kavi"
name1="Arun"
console.log(name1)*/

//1.3 But if const variable contains list, map objects, elements can be added to it
const name2={name:["Ajith"]}
name2.name.push("Kavi")
console.log(name2)

//Working with objects and arrays
const name3={
    cname:"Ajith",
    age:23,
    hobby: ["music","games"],
    movies: [{
        mname:"Scumbag",
        year:2022
    }]
};
//let cname = cname3.name;
//let {cname,age} = name3;
//let {cname:firstname,age} = name3;
//console.log(firstname,age)
let {movies:[{mname,year}]} = name3;
console.log(mname)

//foreach loop for inner list
const name4={
    cname:"Ajith",
    age:23,
    hobby: ["music","games"],
    movies: [{
        mname2:"Scumbag",
        year:2022
    },
    {
        mname2:"Bloody",
        year:2021
    }]
};
name4.movies.forEach(movie => {
    let {mname2} = movie;
    console.log(mname2);
})

//1.4 Arrow function
// Array map funciton
const numbers = [0,1,2]
numbers.map(function(number){
    //console.log(number);
    return console.log(number);
})

// The above method is replaced by this
//no need to mention brackets and return for single line statements
// also paranthesis is not needed for single parameter
numbers.map(number => console.log(number));

// this variable
const quotient = {
    numbers:[1,2,3,4,5,6],
    results:[],
    dividefn: function(divisor){
        let that = this;
        return this.numbers.map(function(divident){
            //If we use arrow function instead of above this variable is lexically binded
            if(divident%divisor ===0){
                return that.results.push(divident);
            }
        }); // or use .bind(this) here instead of that variable
    }  
};

// 1.5
// Rest parameters no need to specify arguments
function add(...numbers){
    return numbers.reduce((acc,number) => acc+number);
}
console.log( add(3,2,1));

//spread operator - combine arrays
const fruit = ["apple","mango"]
const moreFruit = ["grapes"]
const allFruits = [...fruit,...moreFruit];
console.log(allFruits)

//Default parameters
function mutliply(num=0,multiplier=1){
    return num*multiplier;
}
console.log(mutliply());
console.log(mutliply(5));
console.log(mutliply(5,2))

//1.6 string literal
var place = `2/87
    Middle street`;
console.log(place);

//1.7 class, extend, super and syntatic sugars
class Car{
    constructor(make,color,speed){
        this.make = make,
        this.color = color,
        this.speed = speed
    }
    getSpeed(){
        console.log(this.make);
        return `Maximum speed is ${this.speed} km/h`;
    }
}

class Truck extends Car{
    constructor(make,color,speed,year){
        super(make,color,speed);
        this.year = year;
    }
    getSpeed(){
        return super.getSpeed();
        //return `Maximum truck sppedd is ${this.speed} km/h`;
    }
    getYear(){
        return `truck maked year is ${this.year}`;
    }
}

const car = new Car('BMW','black',250);
console.log(car.getSpeed());
const truck = new Truck('volvo','blue',120,2022);
console.log(truck.getSpeed());
console.log(truck.getYear());

//1.8 Modules
//use export keyword to var
// export const pi = 3.14
// use import * as math from "./utils"; (file)
// math.pi;
// OR 
// use import {pi} from "./utils"; (file)
// pi;
// use import {pi as math} from "./utils"; (file)
// math