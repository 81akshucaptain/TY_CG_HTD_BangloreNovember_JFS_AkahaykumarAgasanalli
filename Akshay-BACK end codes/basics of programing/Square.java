class Square{
static int area(int a)
{
int res1=a*a;
return res1;
}
static int peri(int a)
{
int res2=4*a;
return res2;
}
public static void main(String a[])
{
int area=area(6);
System.out.println("the area of square is :"+area);
int peri=peri(8);
System.out.println("the area of peri is :"+peri);
}
}