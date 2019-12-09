package abstraction;

public class Test {
	int cost;
	Test(int cost){
		this.cost=cost;
	}
}
class Car extends Test{
	Car(int a){
		super(a);
	}
}
