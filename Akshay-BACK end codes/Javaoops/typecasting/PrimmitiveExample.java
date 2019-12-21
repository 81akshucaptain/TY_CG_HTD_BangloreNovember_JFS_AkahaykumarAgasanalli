package typecasting;

public class PrimmitiveExample {
public static void main(String[] args) {
	MainTest m=new MainTest();
	m.diplay();
	}
}
class MainTest{
		 int x=2;
			double y=2.589587;
			int q=(int) y;
			
			
		 void diplay() {
			 y=(double)q;

			 
			 System.out.println("the value of q: "+q);
			 System.out.println("the value of p: "+y);

			 

		 } 
	 }