package arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class P {
	public P(String s) {
		System.out.println("------------------------------------" + s);
	}
}

public class ArrayListEx {

	public ArrayListEx() {
		System.out.println(
				"ArraaayyListEX");
	}

	public void disp(int b, String... strings) {
		System.out.println(strings[strings.length - 1] + " ");
	}

	public static void main(String[] args) {

		new P("bob");

		new ArrayListEx().disp(5, "strings1");
		new ArrayListEx().disp(5, "strings1", "strings2");

//		int x,y,z;
//		System.out.println("***********************************"+x+y+z);
////		ArrayList<Long> a = new ArrayList<Long>();
//		a.add(Long.valueOf(10));
//		List<Number> a2=a;
//		System.out.println(a2);
//		
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.add(11);
		a.add(05);
		a.add(300);
		a.add(400);
		a.add(10);

		ArrayList<String> a10 = new ArrayList<String>();
		// a10.add(0, "Jack");
		a10.add(1, "Jack");
		/*
		 * Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 3,
		 * Size: 1 at java.util.ArrayList.rangeCheckForAdd(ArrayList.java:665) at
		 * java.util.ArrayList.add(ArrayList.java:477) at
		 * arraylist.ArrayListEx.main(ArrayListEx.java:21)
		 */

		a10.add(3, "Sparrow");
		System.out.println("Special case:---" + a10);

		System.out.println("OOOOOOOO" + a);
		// Sorting
		System.out.println("Sort STARTED....!");
		a.sort(Comparator.naturalOrder());
		;
		Collections.sort(a);
		;
		System.out.println("Sort ENDED....!");

		// Collections.sort(a);
		Iterator<Integer> ii = a.listIterator();
		System.out.println("USING ForEachRemaining......");
		ii.forEachRemaining(j -> {
			System.out.println(j);
		});

		List<String> sortEx = new ArrayList<String>();
		sortEx.add("spoo");
		sortEx.add("aboo");
		sortEx.add("sahana");
		// SORTING USIMG LAMBDA EXP
		sortEx.sort((sortEx1, sortEx2) -> ((String) sortEx1).compareTo((String) sortEx2));

		// Adding AL inside another AL
		List<Integer> a2 = new ArrayList<Integer>();
		a2.add(1);
		a2.add(2);
		a2.addAll(a);

		System.out.println("The Inside elements are : ---" + a2);

		Iterator<Integer> itr = a.iterator();
		// System.out.println("GET elemenmt is: "+a.get(0));
		while (itr.hasNext()) {
			System.out.println("elements are: " + itr.next());
		}
		a.remove(0);
		Iterator<Integer> itr1 = a.iterator();
		// System.out.println("GET elemenmt is: "+a.get(0));
		while (itr1.hasNext()) {
			System.out.println("Updated elements are: " + itr1.next());
		}
		a.removeAll(a);
		Iterator<Integer> itr2 = a.iterator();
		// System.out.println("GET elemenmt is: "+a.get(0));
		while (itr2.hasNext()) {
			System.out.println("Final elements are: " + itr2.next());
		}

		// Using Custom Object in AL
		CustomObjectExample coe1 = new CustomObjectExample("Zagawalli", 28, 22);
		CustomObjectExample coe2 = new CustomObjectExample("Criminal", 20, 20);
		CustomObjectExample coe3 = new CustomObjectExample("Aahana", 25, 28);
		List<CustomObjectExample> ex = new ArrayList<>();
		ex.add(coe1);
		ex.add(coe2);
		ex.add(coe3);

		// USING THE COMPARABLE INTERFACE
		/*
		 * Collections.sort(ex);
		 * 
		 * Iterator<CustomObjectExample> i = ex.iterator(); while (i.hasNext()) {
		 * CustomObjectExample type = i.next(); // i.remove(); System.out.
		 * println("USING COMPARABLE METHOD================================================BASED ON AGE: "
		 * + type.name + ":" + type.age + ":" + type.pin);
		 * 
		 * }
		 */

		// USING COMAPARATOR METHODS
		Comparator<CustomObjectExample> com = new Comparator<CustomObjectExample>() {

			@Override
			public int compare(CustomObjectExample o1, CustomObjectExample o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		};
		Collections.sort(ex, com);
		Iterator<CustomObjectExample> i = ex.iterator();
		while (i.hasNext()) {
			CustomObjectExample type = i.next();
			// i.remove();
			System.out
					.println("USING OMPARATOR METHOD$$$$4BASED ON AGE: " + type.name + ":" + type.age + ":" + type.pin);

			/*
			 * // USING Standard Collections way SORTING Collections.sort(ex,
			 * Comparator.comparing(CustomObjectExample::getName));
			 * 
			 * System.out.println("Custom Object Example:-->" + ex); // USING ITERATORT()
			 * interface
			 * 
			 * while (i.hasNext()) { CustomObjectExample type = i.next(); // i.remove();
			 * System.out.println("THE CUSTOME OBJECT IS: " + type.name + ":" + type.age +
			 * ":" + type.pin);
			 * 
			 * }
			 * 
			 * // USING FOREACH only traverse in forward for (CustomObjectExample cod : ex)
			 * { System.out.println("USING FOR EACH:-->" + cod.name + ":" + cod.age + ":" +
			 * cod.pin); }
			 * 
			 * // USING FOR EACH WITH LAMDA System.out.println("Using FOREACH WITH LAMDDA");
			 * ex.forEach(ex1 -> System.out.println(ex1));
			 * 
			 * // USING LIST ITERATOR(Can traverse Both Forward and backward
			 * Iterator<CustomObjectExample> li = ex.listIterator();
			 * 
			 * while (li.hasNext()) { CustomObjectExample customObjectExample =
			 * (CustomObjectExample) li.next();
			 * System.out.println("USING LISTiterator: --->" + customObjectExample.name +
			 * ":" + customObjectExample.age + ":" + customObjectExample.pin); }
			 */

		}

	}
}

class CustomObjectExample implements Comparable<CustomObjectExample> {
	String name;
	int age;
	int pin;

	public CustomObjectExample(String name, int age, int pin) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public int compareTo(CustomObjectExample o) {
		// TODO Auto-generated method stub
		return this.getAge() - o.getAge();
	}

}
