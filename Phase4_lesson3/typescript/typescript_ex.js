var str = "Hello world";
function func() {
    console.log(str);
}
func();
const numbers = [0, 1, 2, 3];
const greaterThanTwo = numbers.filter(number => number > 2);
console.log(greaterThanTwo);


// call and back methods
// diff is call accepts as individual arguments 
// and apply will accept array of elements
let car = {
    cardId:123,
    getId:function(id,id1){
        return this.cardId + " " + id + " " +id1; 
    }
};

let newCar = {
    cardId:456
}

//console.log(car.getId.call(newCar));
console.log(car.getId.call(newCar,678,890));
console.log(car.getId.apply(newCar,[678]));

//bind borrows function of another object
let car2= {
    cardId:123,
    getId:function(){
        return this.cardId ; 
    }
};

let newCar2 = {
    cardId:456
}
let newFunc = car2.getId.bind(newCar2);
console.log(newFunc());

//Closure
// makes private variable
let app = ( function () {
    let carId = 123;
    let getId = function() {
        return carId;
    };
    return {
        getId: getId
    };
})();
console.log( app. getId() );
//console.log( app()) ;

let app2 = ( function counter() {
    let carId = 123;
    let getId2 = function(){
        return carId;
    };
    return function(){
        carId += 1;
        return carId + " " + getId2();
    };
})();
console.log( app2() );
console.log( app2());

