
package TreeSetEx;

public class StudentEx implements Comparable{
int age;
String name;
public StudentEx(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}

@Override
public String toString() {
	return "StudentEx [age=" + age + ", name=" + name + "]";
}

/*@Override
public int compareTo(Object o) {
	StudentEx o1=(StudentEx)o;
if(this.age>o1.age) {
	return 1;
}
else if(this.age<o1.age) {
	return 0;
}
else {
	return 0;
}
}*/
public int compareTo(StudentEx o) {
	return this.name.compareTo(o.name);
}

@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
}
