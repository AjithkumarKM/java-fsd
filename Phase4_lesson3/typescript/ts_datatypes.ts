//Primitive data types
//boolean
const isAdmin: boolean = true;
console.log(isAdmin);

//number
const numb: number = 23;
console.log(numb);
const hexd: number = 0xa00f;
console.log(hexd);
const bin: number = 0b1100;
console.log(bin);

//String
const user: String = "Ajith";
console.log(user);

//Non primitive datatypes
//Array
const number1: number[] = [0,1,2];
number1.push(4);
console.log(number1);

const number2: Array<number> = [0,1];
console.log(number2);

const mixed: (number|String)[] =[1,"Ajith"];
const mixed2: Array<number|String> = [0,"Ajith"];
mixed.push(3);
mixed.push("Kavi");
console.log(mixed);
console.log(mixed2);

//Tuple
let mix: [String,number];
mix = ["Ajith",23];
console.log(mix);
console.log(mix[0].toUpperCase());

//Enum
enum cardType {Hearts=1,Diamonds,Spades,Clubs};
let myCard: cardType = cardType.Hearts;
console.log(myCard);

let myCard2: String = cardType[2];
console.log(myCard2);

//Any
const data: any = 4;
console.log(data);
//const data2: any[] = [4,"Ajith",false];

//Never - type os values that would never occur
function error():never{
    throw new Error('error!');
};

function fail(){

}

function infinite():never{
    while(true){}
}

//null and undefined
let nullVal: null = null;
let undefinedVal: undefined = null;
let undefinedNumber : number = 23;
//is strictnullchecks is set true in config file cannot assign 
//udefined vlaues
undefinedNumber = undefined;
console.log(undefinedNumber);

//functions Void
function greet(name) : void{
    console.log(`Hello ${name}`);
}
greet("Ajith");

//function
function greet1(name:String) : String{
    return `Hello ${name}`;
}
const greetAjith = greet1("Ajith");
console.log(greetAjith);

//type - aliasing, type and interface are different
type User = {
    name: string;
    age:number;
};

const myUser: User = {
    name: "Ajith",
    age: 23
};
console.log(myUser);

//Type Assertion - Tell compiler that type is imp
type User2 = {
    name: string;
    age:number;
};

//const myUser2: User2 = {};
const myUser2 = {};
(myUser2 as User2).age = 23;
console.log(myUser2);

const myUser3 = {};
(<User>myUser3).age = 23;
console.log(myUser3);

//Objects
const users: {name:string, age:number}[] = [
    {
        name:"Ajith",
        age:23
    },
    {
        name:"Kavi",
        age:10
    },
]
console.log(users);