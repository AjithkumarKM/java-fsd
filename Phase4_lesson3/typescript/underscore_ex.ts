//Lesson 8 Typing transpilation and debugging
// To work with untyped jquery and javascript
import * as _ from "underscore";
import * as fs from "fs";
import { max } from "underscore";
const users: {name:string,age:number}[] = [
    {
        name:"Ajith",
        age:23
    },
    {
        name:"Kavi",
        age:18
    }
];
const maxAge = _.max(users,user => user.age);
console.log(maxAge);

const file: string = fs.readFileSync('./summa.txt','utf-8');
console.log(file);
