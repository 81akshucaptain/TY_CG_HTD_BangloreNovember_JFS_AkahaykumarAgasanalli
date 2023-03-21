package PriorityQueueEx;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class Students implements Comparable<Students> {
	int salary;
	String name;

	public Students(int salary, String name) {

		this.salary = salary;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Students std = (Students) obj;
		return Double.compare(salary, std.salary) == 0 && Objects.equals(std.name, name);
	}

	@Override
	public String toString() {
		return "The Students are-> Name: " + this.name + " Salary: " + this.salary;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(salary, name);
	}

	@Override
	public int compareTo(Students o) {
		// TODO Auto-generated method stub
		if (this.salary > o.salary) {
			return 1;
		} else if (this.salary < o.salary) {
			return -1;
		} else
			return 0;

	}

}

public class PQMainEx {
	public static void main(String[] args) {
		// USING CUSTOM COMPARATOR
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};

		PriorityQueue<String> pq = new PriorityQueue<String>();

		
		//pq.add(null); NOT ALLOWEDs
		pq.add("F");
		pq.add("G");
		pq.add("A");
		pq.add("C");
		pq.add("D");
		pq.add("E");
		
		
		System.out.println("Output of Priority Queue------"+pq);
		while (pq.isEmpty() != true) {
			System.out.println("Using custome Length Ex by removing:->" + pq.remove());

		}

		// FOR CUTOM OBJECTS
		PriorityQueue<Students> student = new PriorityQueue<>();
		student.add(new Students(100, "name4"));
		student.add(new Students(12, "name2"));
		student.add(new Students(01, "name3"));

		while (!student.isEmpty()) {
			System.out.println("THE CUSTOME OBJECT IS:--->" + student.remove());
		}

		/*
		 * PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); pq.add(300);
		 * pq.add(1000); pq.add(20); pq.add(10); System.out.println(pq);
		 * System.out.println("Front End Elements:"+pq.remove()+":"+pq);
		 */
	}

}
