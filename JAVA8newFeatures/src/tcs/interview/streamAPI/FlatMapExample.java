package tcs.interview.streamAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Developer {

	private Integer id;
	private String name;
	private Set<String> book;

	// getters, setters, toString

	public void addBook(String book) {

		this.book = new HashSet<>();

		this.book.add(book);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

}

public class FlatMapExample {
	public static void main(String[] args) {

		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		/*
		 * First, we try the Stream#filter directly. However, the below program will
		 * print nothing, and it is because the x inside the Stream#filter is a
		 * String[], not a String; the condition will always remain false, and the
		 * Stream will collect nothing. Hence we can Refactor like below
		 * 
		 * 
		 * 
		 * // array to a stream
		 * 
		 * Stream<String[]> stream1 = Arrays.stream(array);
		 * 
		 * // x is a String[] List<String[]> result = stream1 .filter(x -> { for(String
		 * s : x){ // really? if(s.equals("a")){ return false; } } return true;
		 * }).collect(Collectors.toList());
		 * 
		 * // print array result.forEach(x -> System.out.println(Arrays.toString(x)));
		 */

		// So here FLAT MAP comes in picture, It’s challenging to process a Stream
		// containing more than one level,
		// And we flat the 2 levels Stream into one level, so that we can easily loop
		// the Stream and process it.

		// One way
		/*
		 * Stream<String[]> stream2 = Arrays.stream(array); // Stream.of(array) same as
		 * that
		 * 
		 * List<String> list = stream2.flatMap(Stream::of).filter(a ->
		 * !a.startsWith("a")).collect(Collectors.toList());
		 */

		List<String> list = Stream.of(array).flatMap(Stream::of)
				.filter(a -> !a.startsWith("a"))
				.collect(Collectors.toList());
		list.forEach(System.out::println);

		Developer o1 = new Developer();
		o1.setName("mkyong");
		o1.addBook("Java 8 in Action");
		o1.addBook("Spring Boot in Action");
		o1.addBook("Effective Java (3nd Edition)");

		Developer o2 = new Developer();
		o2.setName("zilap");
		o2.addBook("Learning Python, 5th Edition");
		o2.addBook("Effective Java (3nd Edition)");

		List<Developer> list5 = new ArrayList<>();
		list5.add(o1);
		list5.add(o2);

		// hmm....Set of Set...how to process?

		Set<String> set1 = list5.stream().map(n -> n.getBook()).flatMap(n -> n.stream())
				.filter(x -> !x.contains("Python")).collect(Collectors.toSet());

		// above map is optional we can write like below
		Set<String> set2 = list5.stream().flatMap(n -> n.getBook().stream()).
				filter(x -> x.contains("Python"))
				.collect(Collectors.toSet());

		set1.forEach(System.out::println);
		set2.forEach(System.out::println);

	}
}
