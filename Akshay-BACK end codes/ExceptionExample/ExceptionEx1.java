package ExceptionExample;

import java.security.acl.AclNotFoundException;
import java.util.Scanner;

public class ExceptionEx1 {
	public static void main(String[] args) {
		System.out.println("main metod sarted");
		int a,b;


		Scanner sc=new Scanner(System.in);



		//System.out.println("enter the array value");
		//a1[1]=sc.nextInt();

		//HANLDE THE EROS OF NULL POINTER and devide by zero
		//THESE ARE RUNTIME EXCEPTIONS
		try {	
			System.out.println("enter the value for a nad b");
			a=sc.nextInt();
			b=sc.nextInt();
			int res=a/b;
			System.out.println("res is:"+res);
		}catch(ArithmeticException e) {
			String s1=e.getMessage();
			System.out.println("dear, user"+s1+" is not possible budyy");
			try {
				int a1[]=new int[0];
				System.out.println("enter the array value");
				a1[5]=sc.nextInt();
			}catch(ArrayIndexOutOfBoundsException e3) {
				String s3=e3.getMessage();
				System.out.println("array is "+e3);
				try {
					System.out.println("enter the string");
					String c=null;
					System.out.println(c.length());
				}catch(NullPointerException e2) {
					String w=e2.getMessage();
					System.out.println("the exception is: "+w);
				}
			}


		}
		finally {
			System.out.println("compulsory lines to be executed by jvm no matter what ");
		}
	}

}



