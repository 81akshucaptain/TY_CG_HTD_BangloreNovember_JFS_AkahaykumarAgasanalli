package QueueExample;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx1 {
	public static void main(String[] args) {
		Queue q=new PriorityQueue<>();
		q.offer(5);
		q.offer(2);
		q.offer(0);
		q.offer(58);
		q.offer(24);
		q.offer(69);
		q.offer(35);
		q.offer(3);

		System.out.println("the elements:"+q);
		System.out.println(	"the element method :"+q.element());
		System.out.println("after polling::: "+q.poll());
		q.poll();
		System.out.println("after polling "+q);

		System.out.println("after removing least element: "+q);
		for (Object object : q) {
			System.out.println(object);
			}
			
			PriorityQueue<StudentEx> p1=new PriorityQueue<StudentEx>();
		p1.offer(new StudentEx(22,"akshu"));
		p1.offer(new StudentEx(18,"mowna"));
		p1.offer(new StudentEx(45,"manu"));
		 for (StudentEx object2 : p1) {
			System.out.println(object2.age+" "+object2.name);
		}
		
		
		}
	}

