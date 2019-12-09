package ENCApsulate;

public class WrapperClass {
	public static void main(String[] args) {
		int a=10;
		System.out.println(a);
		Integer i=new Integer(a);//WRAPPER CLASS BOXING
		System.out.println(i);
		int b=i;//UnBOXING
		System.out.println(b);
		//OR using intVLUE
		b=i.intValue();
		System.out.println(b);
		//USING intValue() to convert NONprimitive to PRIMITIVE
		double q=12.35;
		System.out.println(q);
		Double w=new Double(q);
		System.out.println(w);
		double e=w.doubleValue();
		System.out.println(e);
		//USING UPandDOWN CASTING
		double r=(Double)w;
		System.out.println("using upDown casting"+r);
	}

}
