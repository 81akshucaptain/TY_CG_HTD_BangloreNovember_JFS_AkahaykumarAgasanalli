//ARRAYS ARE HETEROGENEOUS IN NATURE
//  var technplogies = ['java','pyhton',123,true,null];

// // console.log(technplogies[2]);
// // console.log(technplogies[10]);

// //USING FOR-OF LOOP
// for (let iterator of technplogies) {
//     console.log("the value of arrays:"+iterator);
// }

// //USING FOR-IN LOOP
// for (let index in technplogies) {
//         console.log("index with : "+index+ "the value is:"+technplogies[index]);
// }

// var person = {
//     aadharNo: 124578,
//     voterId:12
// }

// var personPan = {
//     panNo:12121,

// }
// var student = {
//     ...person,
//     ...personPan,
// id:123,
// name:'akshay',
// degree:'BE',
// phone:8965325689
// }
// for (let key in student) {
// console.log(key+"::::"+student[key]);        
// }
 
//METHODS IN ARRAYS
//CALLBACK FUNCTION IS BEING USED FOR fOReACH
// technplogies.forEach((values,index)=>{
// console.log(values);
// console.log("after multiplied by * 3 :"+values*3);
// console.log(index);
// });

//INDEXOF
// console.log("index of 123 is :"+technplogies.indexOf(123));

// POP()
//removes @ last index
// console.log("before pop",technplogies);
// console.log( technplogies.pop());
// console.log("after pop",technplogies);

// PUSH()

// console.log("before push",technplogies);
// //we can add multiple elements,@Last postition
// console.log( technplogies.push("anish","dijango","machineLearning"));
// console.log("after push",technplogies);

//SHIFT()
//Remove @ 0th index
// console.log("before shift",technplogies);
// console.log( technplogies.shift());
// console.log("after shift",technplogies);

//UNSHIFT()
//Add @ 0th index
// console.log("before unsift",technplogies);
// console.log( technplogies.unshift("javaAllAMAva"));
// console.log("after unsift",technplogies);

//SPLICE()

//starting index, no of elements to be deleted, elements to be added
// technplogies.splice(2,0,'html','css','bootstrap');
// console.log("splice applied:",technplogies);

// technplogies.splice(technplogies.indexOf(123),2);
// console.log("splice deletion happened:",technplogies);

// //FIND THE LENGTH OF ARRAY
// console.log(technplogies.length);

// //REVERSE THE ARRAY
// technplogies.reverse();
// console.log("REVERSED ARRAY: ",technplogies);

//FILTER
//Taking call back as the arguments

 var marks=[2,45,21,87,56,24,87,21,2,45,35];
// let filteredArray=marks.filter((value,index,marks)=>{
// return value>30;
// });
// console.log("Old array",marks);
// console.log("Marks greater than 30:",filteredArray);
// console.log("length of marks gretaer than 30:",filteredArray.length);

// //FINDING THE SIMILAR VALUES
//Taking call back as the arguments
// let filteredArray2=marks.filter((value,index,marks)=>{
//     return marks.indexOf(value)===index;
//  });

//  console.log('after sorting unique values',filteredArray2);


//MAP
//Taking call back as the arguments
// let myArray=marks.map((value,index,array)=>{
// return {ind: index, vla:value};
// });

// console.log("after maping,the new objects",myArray);

//SORTING
//IT will return new array with sorted elements
//ASCENDING SORT

let soretedArray=marks.sort((a,b)=>{
return a-b;
});

console.log("ascending sorts: ",soretedArray);

//DESCENDING SORT
let soretedArray2=marks.sort((a,b)=>{
    return b-a;
    });
    
    console.log("descendinig sorts: ",soretedArray2);











