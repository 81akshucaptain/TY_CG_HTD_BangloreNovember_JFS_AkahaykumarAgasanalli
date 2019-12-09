package abstraction;

abstract public class HeroHonda {
	abstract void design();
	abstract void engine();
}

abstract class Hero extends HeroHonda{
	void design() {
		System.out.println("desing method is been implemented\n");
	}
}
class Honda extends Hero{
	void engine() {
		System.out.println("engine method is been implemented");
	}
	
}
