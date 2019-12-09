package FinalExample;

abstract public class MagicConstroctor {
	final int MAXIMUM;
	static int x;
	MagicConstroctor(){
		System.out.println("in constructor-----");
	}
	{
		MAXIMUM=2000;
		System.out.println("in constructor"+MAXIMUM);
		x=100;
	}
	abstract void magic();
	void display(int a,int b) {
		System.out.println("the final nethod ");
	}
}
class demo extends MagicConstroctor{
	void display(int a,double c) {
		System.out.println("we cant override but we can overloade");
	}
	void magic() {
		System.out.println("magic method implemented");
	}
}

