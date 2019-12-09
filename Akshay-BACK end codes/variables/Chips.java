package variables;

public class Chips {
	void open() {
		System.out.println("open chips");
	}
	void eat() {
		System.out.println("eat chips");
	}

}
class Lays extends Chips{
	void open() {
		System.out.println("open lays");
	}
	void eat() {
		System.out.println("eat lays");
	}
}
class Bingo extends Chips{
	void open() {
		System.out.println("open bingo");
	}
	void eat() {
		System.out.println("eat bingo");
	}
}

