// console.log('Hello jacky in external js');
//NUMBERS
//variable declaration
var a;
//inintialization
a=25;
//or both
var b=200;
//JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//BEHAVES SYNCHRONIZES,NOW 

console.log('value of a:'+a);
console.log('value of b: '+b);

//To check the type of variable
console.log(typeof a);

//STRING
var name1="captainAK";
var name2='jack sparrow';
var name3=`jackkkkyyy`;
console.log("1: "+name1+"2: "+name2+" 3: "+name3);

//STRING INTERPOLATION,using template lterals with embedded expression
var details1=`the name is ${name1} and age is ${a}`;
console.log(details1);

//COMEDY IN JAVASCRIPT
console.log(`The sum of a and b ${(10+15)}`);

var sampletext='Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis qui quasi voluptatum sint officia perferendis facilis, perspiciatis, voluptas dolorum esse dolor sequi placeat minus laborum hic tempora quisquam repellendus pariatu';
console.log(sampletext);

//BOOLEAN, GIVES TREU OR FALSE
var isCompassCleared=true;
console.log(isCompassCleared);

//NULL, IT WILL PRINT OBJECT
var empty= null;
console.log(typeof empty)

//NORMAL EQUALS 
if (true=="true") {
    console.log('using normal equals true');
}else{
    console.log('using normal equals false');
}

//STRICT EQUALS
if (true==='true') {
    console.log('using STRICT equals true');
}else{
    console.log('using STRICT equals false');
}

//OUTPUT METHODS

// alert('hello im CJS');

var confirmingUser=confirm("are you jack sparrow");
console.log(confirmingUser);
if (confirmingUser) {
    console.log('User verified successfully');
} else {
    console.log('User is not verified');
}

var userInput=prompt('enter your age');
console.log("your age is: "+userInput);

document.write('im document writer, writing in console');

//FUNCTIONS
//Naming Functions
function demo(){
    console.log('im named function');
}
demo();

//LOCAL AND GLOBAL VARIABLE
function add(a,b){
    return a+b;
}

console.log(add(2,5));

//NONYmous function
var test=function(){
    console.log(`anoymous method is called with test variables`);
}
test();

//IMMIDIATE INVOKE FUNCTION
//inorder to use the local variables efficiently
(function demo1(a,b){ 
var myname="akshay";
console.log(a+b);
console.log('inside the IIFE,,name is: ',myname);
console.log('IIFE running');
})(2,2);
//also works as anonymus funtion
(function(a,b){ 
    var myname="akshay";
    console.log(a+b);
    console.log('inside the ANONYMUOUS,,name is: ',myname);
    console.log('IIFE ANONYMUS running');
    })(2,2);
//only locally accessed variables are called,else error
// console.log('outside function:',myname);

//CALLBACK FUNCITONS
function sample(x){
    console.log('sample  function started');
    x();
    console.log('sample function ended');
}
sample(function(){
    console.log('callback function is called, and running');
});








































