package tcs.interview.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestingStreamApI {
	public static void main(String[] args) {
		List<Student> s = new ArrayList<Student>();

		s.add(new Student(100, "zame100"));
		s.add(new Student(02, "name2"));
		s.add(new Student(3000, "bame355"));
		s.add(new Student(50, "aame4"));
		
		s.stream().sorted().forEach(z-> System.out.println(z.getAge()+"==="+z.getName()));;

		ArrayList<Integer> s1 = (ArrayList<Integer>) s.stream().filter(a -> a.age > 20).map(a -> a.age)
				.collect(Collectors.toList());

		s1.forEach(out1 -> System.out.println("OUTput of StreamAPI:--" + out1));

		Student stud = s.stream().max((a1, a2) -> a1.age > a2.age ? 1 : -1).get();
		System.out.println("Max: Aged Student:  " + stud.getName());

		Student stud2 = s.stream().min((a1, a2) -> a1.age > a2.age ? 1 : -1).get();
		System.out.println("Min: Aged Student:  " + stud2.getName());

	}
}

class Student {
	int age;
	String name;

	public Student(int age, String name) {
		super();
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

}