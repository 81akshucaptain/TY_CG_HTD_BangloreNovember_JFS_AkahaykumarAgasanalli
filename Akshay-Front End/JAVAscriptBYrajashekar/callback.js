//JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
// //BEHAVES A-SYNCHRONIZES,NOW 
// console.log('JS stated');
//  setTimeout(function(){
// console.log('waited for 10 seconds');
//  },10000);
//  console.log('JS ended');


//  var i=0;
//  setInterval(function(){
//     console.log(i);
//     i++;
//     console.log('1 seconds done'); 
//  },1000);
//  console.log('JAVASCRIPT ended');

// ECMA SCRIPT 5 & 6
// NEW CONCEPTS ADDED

//1..FAT ARROW FUNCTIONS
// var test=(a,b)=>{
// return a+b;
// }
// console.log(test(12,25));

//we can write in one single line
// var test=(a,b)=>a+b;
// console.log(test(12,35));

//even more simpler if we have single variable
// var test=a=>a*5;
// console.log(test(5));

//2.LET KEY WORD WILL BE HAVING BLOCK LEVEL SCOPE
//VAR IS FUNCTION SCOPE
if ({condition}) {
    let a=100;
    var b=50;
}
// console.log("a-block scope:"+a );
// console.log("b-function scope:"+b );