package objects;
import java.util.*;

public class TestStudent {
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		Student s1 = new Student(45,"tejas",120);
		System.out.println(s1.age + " "+s1.id+  " "+ s1.name);
		int arr[]=new int[5];
		for (int i=0; i<arr.length;i++) {
			System.out.println("enter the value for element : ");
			arr[i]=sc.nextInt();
		}

		for (int j: arr) {
			System.out.println("the value of j:"+j);
			
		}
		
		
	}

}