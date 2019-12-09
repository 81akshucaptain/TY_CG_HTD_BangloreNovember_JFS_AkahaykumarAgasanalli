package QueueExample;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayQueueEx {
public static void main(String[] args) {
	ArrayDeque a=new ArrayDeque();
	a.add(56);
	a.add(32);
	a.add(15);
	a.addFirst(100);
	a.add(20);
	a.add(55);
	
	Iterator i=a.iterator();
	while (i.hasNext()) {
		Object object = (Object) i.next();
		System.out.println(object);
		
	}
	
}
}
