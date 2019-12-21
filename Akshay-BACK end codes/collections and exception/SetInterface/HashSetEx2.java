package SetInterface;

import java.util.HashSet;

public class HashSetEx2 {
public static void main(String[] args) {
	HashSet<Student> hs1=new HashSet<Student>();
	//we have to override the equals method in student class
	//then only HashSet will vomit the duplicate value else,take,,bcz each 
	//time new object is created
	hs1.add(new Student(22,"akshay"));
	hs1.add(new Student(22,"akshay"));
	hs1.add(new Student(28,"mowna"));
	for (Student object : hs1)
	{
System.out.println(object.age+"  "+object.name);
	}


}
}
