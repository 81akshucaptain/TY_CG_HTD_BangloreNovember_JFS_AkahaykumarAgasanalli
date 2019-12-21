import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class List1 {
	public static void main(String[] args) {
		List l1=new ArrayList();
		l1.add(25);
		l1.add(29);
		l1.add(27);
		l1.add(2,66);//add at particular index
		System.out.println("it is l1: "+l1);
		l1.lastIndexOf(66);
		System.out.println("index of 66: "+l1.lastIndexOf(66));

		List l2=new ArrayList();
		l2.add(32);
		l2.add(27);
		l2.add(36);
		l2.add(2,99);//add at particular index
		System.out.println("it is l2: "+l2);
		System.out.println(l2.lastIndexOf(36));
		//USING NORMAL FOR LOOP
		for (int i = 0; i < l2.size(); i++) {
			System.out.println("element in l2 is ...: "+l2.get(i));
		}
		//USING FOREACH
		System.out.println("printing the vslues based on foreach loop");
		for (Object o : l2) {
			System.out.println("the element in l2: "+o);
		}
		//USING ITERATOR
		System.out.println("printing through ITERATOR ");
		Iterator i1=l2.iterator();
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}

		//USING LIST ITERATOR
		System.out.println("printing thorigh LIST iterator in reverse manner");
		ListIterator li1=l2.listIterator(l2.size());
		while(li1.hasPrevious()) {
			System.out.println(li1.previous());
		}

		//TWIST is,bcz li1 will be at the last ,,then comes back 
		/*while(li1.hasPrevious()) {
		  System.out.println(li1.previous());
	  }
	  while(li1.hasPrevious()) {
		  System.out.println(li1.previous());
	  }*/

		System.out.println("after adding l2 to l1");
		l1.addAll(0, l2);
		System.out.println(l1);

		//SET METHOD .......................
		System.out.println("set method applied at 3");
		l1.set(3, 10000);
		System.out.println(l1);

		List l3=new ArrayList();

		System.out.println("the sublist in l1 is created: "+l1.subList(3, 5));
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		//FOR INTEGER VALUES
		ArrayList z1=new ArrayList();
		z1.add(25);
		z1.add(65);
		z1.add(89);
		z1.add(82);
		System.out.println("the elements in the z1: "+z1);
		System.out.println("while removing integer value plz pass \n new object to it else it will gone consider it as index");
		z1.remove(new Integer(89));
		System.out.println("after removing the value"+z1);
		System.out.println("-------------------------*********************");


		//FOR STRING VALUES
		ArrayList<String> z2=new ArrayList<String>();
		z2.add("akshu");
		z2.add("mowna");  
		
		z2.add("kavya");
		z2.add("manu");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("THERE IS ONLY 3 BEST FRIENDS,system SELECT THEMs");
		z2.remove(new String("akshu"));
		System.out.println(z2);
		for (String string : z2) {
			System.out.println("the names in the z2 is: "+string);
		}
		System.out.println("the elements in the z2: "+z2);
		z2.remove("manu");
		System.out.println("after removing the value"+z2);
		z1.addAll(z2);
		System.out.println("AFTER ADDING ALL THE ELEMENTS OF z2 to z1");
		System.out.println(z1);
		System.out.println("is z1 contains the 65"+z1.contains(65));
		System.out.println("is z1 empty ?"+z1.contains(65));

		z1.removeAll(z2);	
		System.out.println("AFTER removing ALL THE ELEMENTS OF z2 to z1"+z1);
		z1.retainAll(z2);
		System.out.println("AFTER retainig ALL THE ELEMENTS OF z2 to z1"+z1);
		z1.clear();
		System.out.println("AFTER clearing ALL THE ELEMENTS OF z1"+z1);

	}
}
