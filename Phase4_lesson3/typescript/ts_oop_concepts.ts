//Interfaces
interface Iuser{
    name:String;
    age:number; // readonly age:number -> cannot change value
    address?: string; //optional
}

let myuser: Iuser = {
    name:"Ajith",
    age:23
}
let myuser2: Iuser = {
    name:"Kavi",
    age:10,
    address:"Kattuedaiyar"
}
console.log(myuser);
console.log(myuser2);

//Example2
interface Igreet{
    //function with two parameters with return type string
    (name:string,labguage: string):string
}

let greet2:Igreet;
greet2 = function(n:string,lang:string){
    return `Hello ${n}`;
}
console.log(greet2("Ajith","English"));

//Diff btw types and interface
//1. Interface can be used with extends and implements keyword
//2. If interface with same name is created, they are merged.
// type alias cannot

//Extends Keyword
interface Iperson{
    name:string;
}

interface Ihero extends Iperson{
    superpower:string;
}

let ironMan : Ihero = {
    name:"Ajith",
    superpower:"Suit"
}
console.log(ironMan);

//Index signature
// cna have any value not defined in the interface
interface Iuser2{
    name:string;
    readonly age: number;
    [property:string]:any;
}

let user2 : Iuser2 = {
    name:"Ajith",
    age:23,
    address:"Kattuedaiyar",
    college:"Mit"
}
console.log(user2);