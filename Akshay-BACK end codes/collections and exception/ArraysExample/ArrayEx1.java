package ArraysExample;
import java.util.Scanner;
public class ArrayEx1 {
	public static void main(String[] args) {
		int[] a=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value for arrays");
		for (int i = 0; i < a.length; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println("the value of elemnt "+i+" is "+a[i]);
		}

	}
}
