package tcs.interview.funcctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class TestingFunctionalInterfaces {
	public static void main(String[] args) {
		// CONSUME
		Consumer<String> con = MainExample::view;
		con.accept("JackSparrow");

		Consumer<List<Integer>> con2 = MainExample::addList;

		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(10);
		al1.add(60);
		al1.add(68);
		al1.add(90);
		System.out.println("LIST output");
		con2.accept(al1);

		// FUNCTION
		Function<Integer, Integer> fun = MainExample::returingValue;
		System.out.println("Output of function: " + fun.apply(10));

		// PREDICATE
		Predicate<Integer> pre = a -> a > 10;
		System.out.println("Output of Predicate:" + pre.test(15));

	}
}

class MainExample {
	public static void view(String name) {
		System.out.println("The view is :" + name);
	}

	public static int returingValue(int val) {
		return val * 10;
	}

	static void addList(List<Integer> list) {
		// Return sum of list values
		int result = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum of list values: " + result);
	}
}
