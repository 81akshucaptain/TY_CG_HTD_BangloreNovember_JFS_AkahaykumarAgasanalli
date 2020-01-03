var date=new Date();
console.log("Todays date: ",date.getDate());
console.log("Current month: ",date.getMonth());
console.log("Current year: ",date.getFullYear());
console.log("hours: ",date.getHours());

setInterval(()=>{
    var date=new Date();
document.getElementById('todaysDate').innerHTML =`DATE::${date.getDate()}
-${date.getMonth()+1}-${date.getFullYear()}  TIME::: ${date.getHours()}
-${date.getMinutes()}-${date.getSeconds()}`;
});