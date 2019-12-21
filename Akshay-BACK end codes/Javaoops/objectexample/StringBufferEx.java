package objectexample;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer s1=new StringBuffer("akshay");
		System.out.println(s1.hashCode());
//same hashCode() will be generated
		s1=s1.append("mowna");
		System.out.println(s1.hashCode());
	}
}
