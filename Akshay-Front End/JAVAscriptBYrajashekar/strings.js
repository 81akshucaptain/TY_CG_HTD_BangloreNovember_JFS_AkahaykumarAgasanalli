//STRING METHODS
let message = 'good morning jack sparrow';

//CHAR-CODE-AT(...)
// FOR ASCII VALUE OF THE GIVEN INDEX
console.log( message.charCodeAt(5));

//CHAR-AT(..)
//RETURN THE CAHRECTER AT THE SPECIFIED 
console.log(message.charAt(5))

let splitmsg=message.split('');
console.log("splited message: ",splitmsg);

//REVERSING THE STRING
let splitmsg2=message.split('').reverse().join('');
console.log("splited and reversed: ",splitmsg2);

//INCLUDES???
//to check weather a particular string is present or not
console.log(message.includes('good'));

//TO-UPPER and LOWER CASES
console.log(message.toUpperCase());
console.log(message.toLowerCase());
console.log(message.toLocaleLowerCase());

//SUB-STRING
console.log("SubString : ",message.substr(0,7));

//USING REST PARAMETER
function add(...nums){
    let sum=0;
    //USING FOR-OF LOOP
    for(let num of nums){
        sum=sum+num;
    }
    console.log('sum of digits',sum);
}

add(12,23,45,67);