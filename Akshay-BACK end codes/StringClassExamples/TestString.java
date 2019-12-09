package StringClassExamples;

public class TestString {
	public static void main(String[] args) {
		CustomeStringClass c1=new CustomeStringClass("akshay",1);
		System.out.println(c1.hashCode());//12354632578
		//assigning the new object to the same reference variable,hence address changes hence
		//two new object will be created,hence string are immutable
		c1=new CustomeStringClass("mowna",78);
		System.out.println(c1.hashCode());
		int age=c1.getAge();
		String name=c1.getName();
		System.out.println(age);
		System.out.println(name);
	}

}
