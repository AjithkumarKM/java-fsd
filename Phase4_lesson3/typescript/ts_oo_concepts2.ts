// default parameter for function
function greet(name:string,age:number = 18) :string {
    return `Hello ${name} and age ${age}`;
}

console.log(greet("Kavi"));
console.log(greet("Ajith",23));

function greet3(name:string,age?:number) :string {
    return `Hello ${name} and age ${age}`;
}
console.log(greet3("Kavi"));
console.log(greet3("Ajith",23));

//Classes
class Person{
    name:string;
    constructor(name:string){
        this.name = name;
    }

    greet():string{
        return `Hello ${this.name}`;
    }
}

let person1 =new Person("Ajith");
console.log(person1.greet());

//Access modifers
//1. public - default, can be accessed other class and instantiation
//2. proctected - containing class + all derived (sub) classes
//3. private - within the class only
//4. readonly - cannot assign new value

// diff btw classes and interface
//1. class can implements interface

//Abstract class
//instantiation cannot be done
abstract class Human{
    public name:string;
    public age: number;
    constructor(name:string){
        this.name=name;
    }

    abstract greet():void;
}

class Person3 extends Human{
    constructor(name:string){
        super(name);
    }
    greet(): void {
        console.log("Hello"!!);
    }
}
let user3 = new Person3("Ajith");
user3.greet();

//Generics
//See google

