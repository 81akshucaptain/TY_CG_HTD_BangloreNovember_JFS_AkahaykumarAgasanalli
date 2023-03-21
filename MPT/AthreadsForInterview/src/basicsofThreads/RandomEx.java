package basicsofThreads;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random r = new Random();
		int i = 0;
		while (i <5) {
			System.out.println("Random no:-" + i + " is " + r.nextInt(50));
			i++;
		}
		r.ints(10, 100).limit(5).forEach(s->System.out.println(s));
	}
}
