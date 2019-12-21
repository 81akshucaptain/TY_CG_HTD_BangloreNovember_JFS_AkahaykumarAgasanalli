package ENCApsulate;

public class TestPerson {
public static void main(String[] args) {
	System.out.println("JAVA beans Class");
	Person p=new Person();
	p.setAge(20);
	p.setName("AKshay");
	System.out.println(p.getAge()+" "+p.getName());
}
}
