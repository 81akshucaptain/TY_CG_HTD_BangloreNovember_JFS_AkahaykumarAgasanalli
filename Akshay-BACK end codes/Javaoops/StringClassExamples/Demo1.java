package StringClassExamples;

public class Demo1 {
	public static void main(String[] args) {
		String s1=new String("Akshay");
		String s5=new String("Akshay");
        System.out.println(s1+"  "+s5);
//String s3=s2;
		//System.out.println("the s2 hashcode : "+s2.hashCode()+"  s3 hashcode is: "+s3.hashCode());
		String s4="kavya";
		String s6="kavya";
		System.out.println(s4.equals(s6));
		
		//built in metods in java String
		String s7="Capatin jack j sparrow";
		System.out.println(s7.toLowerCase());
		System.out.println(s7.toUpperCase());
		System.out.println(s7.isEmpty());
		System.out.println("__________________");
		System.out.println(s7.endsWith("sparrow"));
		System.out.println(s7.indexOf('j',8));
		System.out.println(s7.indexOf("sparrow"));
		
	}
	

}
