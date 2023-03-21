package tcs.interview.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Company {
	String name;
	int size;

	public Company(String com, int s) {
		// TODO Auto-generated constructor stub
		this.name = com;
		this.size = s;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

public class OtherMethodsofStreamAPI {
	public static void main(String[] args) {

		// STREAM AND PARALEL STREAM
		// This signifies at least one thing: that invocation of the
		// list.parallelStream() method makes the println statement operate in multiple
		// threads, something which list.stream() does in a single thread.
		List<Integer> list0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		// prints in ordered way , single sequence every time
		list0.stream().forEach(System.out::println);
		System.out.println("Above is stream---Below is parelell stream");
		// Prints in unordered way, Changes sequence every time
		list0.parallelStream().forEach(System.out::println);

		// Sorting INTEGERS
		List<Integer> list = Arrays.asList(10, 23, -4, 0, 18);

		// Arrays.asList(10, 05, 99, 115,
		// 3).stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		// List<Integer> sortedList =
		// list.stream().sorted().collect(Collectors.toList());
		List<Integer> sortedList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		System.out.println(list);
		System.out.println(sortedList);

		// Sorting STRINGS
		Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon").stream().sorted().forEach(System.out::println);

		// RANDOM Numbers

		Random r = new Random();
		System.out.println("Printing Random Numbers-----");
		r.ints(100, 200).limit(10).forEach(System.out::println);

		// MAP example

		List<Integer> numbers = Arrays.asList(100, 200, 200, 300, 700, 300, 500);
		// The ‘map’ method is used to map each element to its corresponding result.
		// The following code segment prints unique squares of numbers using map.
		// get list of unique squares/10% Increments
		System.out.println("MAP ----->---->---->");
		List<Integer> squaresList = numbers.stream().map(i -> i + (i * 10 / 100)).sorted(Collections.reverseOrder())
				.distinct().collect(Collectors.toList());

		System.out.println(squaresList);

		// TEST

		ArrayList<Company> al = new ArrayList<Company>();
		al.add(new Company("Infy", 10));
		al.add(new Company("Tcs", 20));
		al.add(new Company("wipro", 10));

		al.stream().filter(p -> !p.name.startsWith("I")).map(p -> p.name).forEach(System.out::println);
		// .forEach(c -> System.out.println("Company Details - " + c.getName() + " : " +
		// c.getSize()));

		// Collectors
		/*
		 * Collectors are used to combine the result of processing on the elements of a
		 * stream. Collectors can be used to return a list or a string.
		 */

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		// FIND the Count of the EMPTY string

		int count = (int) Arrays.asList("ak", "", "", "jack", "").stream().filter(x -> x.isEmpty()).count();
		System.out.println("EMPTY String count is : " + count);

		String stringList = Arrays.asList("ak", "", "", "jack", "").stream()
				//.filter(x -> x.isEmpty())
				.map(x->x.concat("AAAAA"))
				. collect(Collectors.joining("--"));

		System.out.println("Appending the Strings to EMPTY: " + stringList);

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty())
				.collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

	}
}
