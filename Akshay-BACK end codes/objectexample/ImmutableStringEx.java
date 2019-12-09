package objectexample;

public class ImmutableStringEx {
	public static void main(String[] args) {
		String s1="AKshu";
		System.out.println(s1.hashCode());
		s1=s1.concat("Mowna");
		System.out.println(s1.hashCode());
	}
}
