package tcs.interview.funcctionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {
	public static void display(String name) {
		System.out.println("name: " + name);
	}

	public static void calculate(int val) {
		System.out.println("Value :" + val);
	}

	public static String returnName(String name) {
		return "Hello: " + name;
	}

	
	public static void main(String[] args) {
		// CONSUMER
        //Consumer can be used in all contexts where an object needs to be consumed,i.e. 
		//	taken as input, and some operation is to be performed on the object without 
		// returning any result.06-Dec-2015

		Consumer<String> c1 = FunctionalInterfaceExamples::display;

		c1.accept("Jacky");

		Consumer<Integer> c3 = FunctionalInterfaceExamples::calculate;

		c3.accept(665);

		// FUNCTION
//		It is a functional interface. It is used to refer method by specifying type of parameter. 
//		It returns a result back to the referred function.
        //Function<Input,ReturnType>
		Function<String, String> fun = FunctionalInterfaceExamples::returnName;

		System.out.println(fun.apply("JACK SPARROW"));

		// PREDICATE
//		it is a functional interface which represents a predicate (boolean-valued function) of one argument. 
//		It is defined in the java.util.function package and contains test() a functional method.

		Predicate<Integer> pred = a -> a > 18;

		System.out.println("The Predicate is: -" + pred.test(5));

	}
}
