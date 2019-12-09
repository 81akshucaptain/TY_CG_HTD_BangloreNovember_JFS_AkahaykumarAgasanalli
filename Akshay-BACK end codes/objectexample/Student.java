package objectexample;

public class Student {
	//this class shows how each and every class extends Object class which is the super,ost class in java
    int age;
	static char a='A';
    String name;
    Double marks;
    
	//alt+shift+s will give the ways to generate automatic CONSTRUCTOR
	public Student(int age, String name, Double marks) {
		super();
		this.age = age;
		this.name = name;
		this.marks = marks;
	}
	@Override //of equals() method of Object class to compare actual object content 
	public boolean equals(Object obj) {
		Student s=(Student)obj;
		
		if(s.age==this.age) 
		{
			if(s.name.equals(this.name)) {
				return true;
				}
			else {
				return false;
			}
		}
			else return false;
			
		}
	

@Override
	public String toString() {
	return "the age,name,marks of student is:::"+age+"  "+name+"  "+marks;
	}
}
