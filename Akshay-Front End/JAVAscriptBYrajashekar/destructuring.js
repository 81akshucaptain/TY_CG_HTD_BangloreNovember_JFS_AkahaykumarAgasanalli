let student={
    id: 123,
    name: 'akshay',
    age: 22
};

let {id,name,...theRest} = student;

console.log("converted ID:",id);
console.log("converted name:",name);
console.log("converted ID:",theRest);

//ARRAY DESTRUCTURING
let marks=[20,40,50,60,30];

let [maths,science,ss,kannada,english]=marks;

console.log("maths score: ",maths);
console.log("science score:",science);
console.log("ss score: ",ss);
console.log("kannda score: ",kannada);i













