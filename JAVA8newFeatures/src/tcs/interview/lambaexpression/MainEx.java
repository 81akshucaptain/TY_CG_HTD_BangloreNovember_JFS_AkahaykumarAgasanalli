package tcs.interview.lambaexpression;

public class MainEx {
	public static void main(String[] args) {
//Using Anonymous CLASS
		int width = 10;
		
//USING ANONYMOUS CLASS class 
//		Drowable d = new Drowable() {
//
//			@Override
//			public void draw() {
//				// TODO Auto-generated method stub
//				System.out.println("The Anonymous CLASS: width: " + width);
//
//			}
//		};

		// USING LAMBA expression
		Drowable d = () -> {
			System.out.println("USING Lambda EXpression :" + width);
		};
//		Drowable d = () -> {
//			return "I have nothing to say";
//		};

		// CLAIING method
		d.draw();

		// SINGLE parameter
		Drowable2 d2 = (hesaru) -> {
			return "nanna name" + hesaru;
		};
		System.out.println(d2.name1("JACKY"));

		// Multiple Parameter
		Drowable3 d3 = (a, b) -> (a + b);
		System.out.println("ADD is: " + d3.add(10, 30));
	}
}
