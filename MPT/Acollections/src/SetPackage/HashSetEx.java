package SetPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
//IMPORTANT 

//FOR ANY OBJECT LEVEL SET CLASS WE NEE TO OVERRIDE THE EQUALS 
//AND HASHCODE METHODS EXPLICITLY in order to AVOID THE DUPLICATES else no
class Student {
	int age;
	String name;

	public Student(int age, String name) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (this == null || obj.getClass() != this.getClass()) {
			return false;
		}

		// Wrapping
		Student s = (Student) obj;

		return (s.name.equals(this.name) && this.age == s.age);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.age;
	}

}

public class HashSetEx {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(100);
		// ALOWS but remove duplicates
		// No insertion order is maintaied
//		hs.add(null);
//		hs.add(null);
//		hs.add(null);
		hs.add(15);
		hs.add(15);
		hs.add(15);
		hs.add(15);
		hs.add(20);
		hs.add(06);
		System.out.println("MINE%%%%%%%%:--  : " + hs);
		// HS wont maintain insertion order hence it is not possible to sort, So
		// Convert the HS to LIST or TreeSet to sort
		String s = "a";
		StringBuilder sb = new StringBuilder("a");
		System.out.println("-----------------------------------------: "+s.contains(sb));
		double d = 1245.0;
		long n = 125;
		Iterator i = hs.iterator();

		System.out.println("BEFORE sort...!");

		while (i.hasNext()) {
			System.out.println("The Item : " + i.next());

		}
		// Sorting can only be applied using LIST methedologies, Hence Usig hs wont work
		List<Integer> l1 = new ArrayList<Integer>(hs);

		Collections.sort(l1, Comparator.reverseOrder());
		// l1.sort(Comparator.naturalOrder());

		Iterator i2 = l1.iterator();

		System.out.println("AFTER Sort...!");

		while (i2.hasNext()) {
			System.out.println("The Item : " + i2.next());

		}

		// FOR OBJECT LEVEL SORTING-------

		HashSet<Student> stud1 = new HashSet<Student>();
//		stud1.add(new Student(10, "teju"));
//		stud1.add(new Student(30, "mowna"));
//		stud1.add(new Student(3, "akshay"));
//		stud1.add(new Student(01, "basu"));
//		stud1.add(new Student(05, "lakan"));
//		
		// If no override of the equals and hascode then duplicate object will be there
		stud1.add(new Student(10, "mowna"));
		stud1.add(new Student(11, "mowna"));
		stud1.add(new Student(10, "mowna"));
		stud1.add(new Student(10, "mowna"));
		stud1.add(new Student(10, "mowna"));

		List<Student> ll2 = new ArrayList<Student>(stud1);

		Collections.sort(ll2, Comparator.comparing(Student::getName));
		System.out.println(" OBJECT sorting started----");

		ll2.forEach(st -> System.out.println("The object AGE: " + st.getAge() + " NAME : " + st.getName()));

	}
}
