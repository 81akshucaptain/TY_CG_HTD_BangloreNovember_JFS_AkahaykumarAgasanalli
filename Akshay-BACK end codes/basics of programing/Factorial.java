class Factorial{
static int facto(int n){
if(n==0)
return 1;
return n*facto(n-1);
}
public static void main(String args[]){
int fact=facto(5);
System.out.println("the fact of given is :"+fact);
}}