package objectexample;

public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneExample c1=new CloneExample("benz");
		Object o1=c1.clone();
		CloneExample c2=(CloneExample)o1;
		System.out.println(c2.name);
		
		Object o2=c2.clone();
		CloneExample c3=(CloneExample)o2;
		System.out.println(c3.name);

		
	}

}
