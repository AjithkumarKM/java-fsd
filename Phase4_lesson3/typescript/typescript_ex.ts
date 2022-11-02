var str = "Hello world";
function func(){
    console.log(str);
}
func();

const numbers  = [0,1,2,3];
const greaterThanTwo = numbers.filter(number => number >2);
console.log(greaterThanTwo);