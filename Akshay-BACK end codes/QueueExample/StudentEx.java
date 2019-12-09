package QueueExample;

public class StudentEx implements Comparable<StudentEx> {
	int age;
	String name;
	public StudentEx(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
//we can ALSO USE COMPARATOR 
	@Override
	public int compareTo(StudentEx o) {
		if(this.age>o.age) {
			return 1;
		}
		else if(this.age<o.age) {
			return -1;
		}
		else return 0;
	}


}
