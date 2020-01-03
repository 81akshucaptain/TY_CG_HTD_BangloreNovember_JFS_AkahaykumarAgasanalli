//OBJECTS
//INHERITATION
//WE CAN INHERITEDD MORE THAN ONE OBJECTS
console.log("student inheriting person and personPan");
var person = {
    aadharNo: 124578,
    voterId:12
}

var personPan = {
    panNo:12121,

}
var student = {
    ...person,
    ...personPan,
id:123,
name:'akshay',
degree:'BE',
phone:8965325689
}

console.log(student.name);
console.log(student['degree']);
console.log(student.aadharNo);
console.log(student.voterId);
console.log(student.panNo);
console.log('Nested objects...')

var student1 = {
    ...person,
    ...personPan,
id:123,
name:'akshay',
degree:'BE',
phone:8965325689,
address:{
    city:'dharwad',
    postal:'dwd12',
    state:'karanataka'
}
}
console.log(student1.address.city);
console.log(student1.address.state);