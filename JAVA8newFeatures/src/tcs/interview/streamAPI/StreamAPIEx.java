package tcs.interview.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	int price;
	String name;

	public Product(int p, String n) {
		// TODO Auto-generated constructor stub
		this.price = p;
		this.name = n;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class StreamAPIEx {
	public static void main(String[] args) {
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(new Product(20000, "zz"));
		p1.add(new Product(400, "Ak"));
		p1.add(new Product(300, "Ak"));
		p1.add(new Product(500, "xx"));
		p1.add(new Product(100, "Ak"));
		p1.add(new Product(800, "Ak"));
		p1.add(new Product(20, "Ak"));
		p1.add(new Product(8000, "Ak"));
		p1.add(new Product(50, "bb"));
		p1.add(new Product(100, "cc"));
//StreamIsAPI: Operates the sources and provide the result without modifying the Original sources 
		// Visits sources only once in life time
		// filters,collects and print and covert to required data structures
		// Filter does filtering
		// Map does fetching the prices+
		// collect does collecting elements as list
		ArrayList<Integer> al1 = (ArrayList<Integer>) p1.stream().filter(p -> p.price > 300).map(p -> p.price+10)
				.collect(Collectors.toList());// Also to covert set we can use toSet(),toMap()

		// ArrayList al1 = (ArrayList) p1.stream().filter(p -> p.price >
		// 300).collect(Collectors.toList());// Also to

		System.out.println("First Prit-------"+al1);

		// COUNT
		long n = p1.stream().filter(p -> p.price > 300).count();
		System.out.println("The counts of greater 300 are:" + n);

		// REDUCE METHOD FOR COLLECTING RESULT
		Integer sum = p1.stream().map(p -> p.price).reduce(0, Integer::sum);
		System.out.println("=============SUM" + sum);
		
		 // Create a list of numbers either positve or negative  
        List<Integer> numbers = Arrays.asList(8, -4, 16, 0, 1, -6, 3);   
        // calculate sum of all the elements of the numbers array using the reduce method   
        float sumOfElements = numbers.stream()
        		.reduce(0, (firstElement, secondElement) -> firstElement + secondElement);   
        // show the result returned by the reduce method  
        System.out.println("The sum of all elements of numbers array " + sumOfElements);   
   
        
     // create a array of monuments to perform operations   
        String[] monuments = { "Taj Mahal", "Qutab Minar", "Konark Sun Temple", "India Gate", "Charminar" };   
        // The reduce() method takes the lambda expression that take two string type values and returns a longer string  
        //The Optional data is returned as a result from the reduce() method because the list can be emplty on which reduce() method is called.  
          
        Optional<String> newCombineMonument = Arrays.stream(monuments).
        		reduce((firstMonument, secondMonument)-> firstMonument + "-" + secondMonument);   
    
        // show the result returned by the reduce method  
        if (newCombineMonument.isPresent()) {   
            System.out.println(newCombineMonument.get());   
        }   

		// SORTED
		ArrayList<Integer> sortAl = (ArrayList<Integer>) p1.stream().filter(p -> p.price > 300).map(p -> p.price)
				.sorted().collect(Collectors.toList());// Also to covert set we can use toSet(),toMap()
		System.out.println("SORTED ARRAY LIST :-" + sortAl);

		// MAX AND MIN
		Product pa = p1.stream().max((p2, p3) -> p2.price > p3.price ? 1 : -1).get();
		System.out.println("Maximum Object by MAX method in stream" + pa.getName() + "--" + pa.getPrice());
		Product pb = p1.stream().min((p2, p3) -> p2.price > p3.price ? 1 : -1).get();
		System.out.println("Maximum Object by MIN method in stream" + pb.getName() + "--" + pb.getPrice());

		// You can use stream to iterate any number of times. Stream provides predefined
		// methods to
		// deal with the logic you implement.
		// In the following example, we are iterating, filtering and passed a limit to
		// fix the iteration.
		// SEED=is the initial entity
		Stream.iterate(100, a -> a + 1).filter(a -> a % 5 == 0).limit(5).forEach(System.out::println);

		//FILTERING ON GIVEN CONDITION 
		System.out.println("My PRINTS ======");
		p1.stream().filter(p -> !p.name.contains("Ak")).sorted(Comparator.comparing(Product::getName))
				.forEach(p -> System.out.println(" : " + p.getName() + " " + p.getPrice()));

		// p1.forEach(ex -> System.out.println("It begin :" + ex.getPrice() + " "));

		//ITERATION on RANDOM numbers 
		Random random = new Random();
		
		random.ints().limit(10).forEach(System.out::println);
		
	}
}
