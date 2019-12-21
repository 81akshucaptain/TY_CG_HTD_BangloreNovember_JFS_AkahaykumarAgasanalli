package variables;

class Variable { 
	int cost=2000;
	void printfun() {
		int cost=1000;
		System.out.println("local variable cost:"+cost);
		System.out.println("global variable cost:"+this.cost);
	}
}
public class SuperVariable extends Variable{
	void printSuper() {
		System.out.println("super varibale cost"+super.cost);
	}
	public static void main(String[] args) {
		Variable c=new Variable();
		c.printfun();
		SuperVariable s=new SuperVariable();
		s.printSuper();
	}
}
