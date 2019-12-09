package ArraysExample;
import java.util.Scanner;

public class CharArrayEx {
	public static void main(String[] args) {
		char[] ch=new char[5];
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < ch.length; i++) {
			System.out.println("enter tha value for "+i);
			ch[i]=sc.next().charAt(0);
		}
		for (int i = 0; i < ch.length; i++) {
			System.out.println("the char element i "+i+" is "+ch[i]);
		}
	}

}
