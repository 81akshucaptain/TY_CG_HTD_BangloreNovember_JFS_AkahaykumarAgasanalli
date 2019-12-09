package objectexample;

public class StringBuilderEx {
	public static void main(String[] args) {
	StringBuilder s1=new StringBuilder("akshy");
	System.out.println(s1.hashCode());
	s1=s1.append("mowna");
	System.out.println(s1.hashCode());
	//same hashcod after appending
	
	}
}
