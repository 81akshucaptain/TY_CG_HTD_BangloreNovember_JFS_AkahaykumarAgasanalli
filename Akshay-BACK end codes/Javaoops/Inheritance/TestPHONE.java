package Inheritance;

public class TestPHONE {
	public static void main(String[] args) {
		System.out.println("!!!!!!!!!0");

		FirstG f1=new FirstG();
		f1.msg();
		f1.call();
		System.out.println("!!!!!!!!!1");
		FirstG f2=new SecondG();
		f2.msg();
		f2.call();
		//f2.radio();we can't achieve this becoz parent wont haave the childs property it can only access its own 
		System.out.println("!!!!!!!!!2");

		SecondG f3=new ThirdG();
		f3.msg();
		f3.call();
		f3.radio();
		//f3.camera();we can't achieve this becoz parent wont haave the childs property it can only access its own 
		

		
	}

}
