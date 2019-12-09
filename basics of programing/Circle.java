class Circle{
static double areaCircle(int r){
double res1=3.142*r*r;
return res1;
}
static double periCircle(int r){
double res2=2*3.142*r;
return res2;
}
public static void main(String ar[])
{
double d1=areaCircle(7);
System.out.println("the are of circle is  "+d1);
double d2=periCircle(8);
System.out.println("the perimetrt of circlr is  "+d2);

}
}