package basicsofThreads;

//NORML BLOCK AND METHOD SYNC DONT WORK AT CLASS LEVEL THEY WORK AT OBJECT LEVELS,
//HENCE 4 DIFFERENT CLASS 
//BELOW HAVE
//ACCESS AT THE SAME TIME TO PRINT METHOD SO PRINTING YETTARA PATTARA, 
//SO FOR CLASS LEVEL ACCESS WE NEED
//STATIC SYNCHRONISATION

/*class Table {
	synchronized static void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
		System.out.println("___________");
	}
}

class MyThread1 extends Thread {
	public void run() {
		new Table().printTable(5);
	}
}

class MyThread2 extends Thread {
	public void run() {
	new Table().printTable(10);
	}
}

class MyThread3 extends Thread {
	public void run() {
		new Table().printTable(15);
	}
}

class MyThread4 extends Thread {
	public void run() {
		new Table().printTable(20);
	}
}

public class StaticSynchronisation {
	public static void main(String t[]) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}*/

////A STATIC KEYWORD IS ENOUGH TO MAKE DIFFERENCE 
class Table {
	synchronized static void printTable(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}
		}
	}
}

class MyThread1 extends Thread {
	public void run() {
		Table.printTable(1);
	}
}

class MyThread2 extends Thread {
	public void run() {
		Table.printTable(10);
	}
}

class MyThread3 extends Thread {
	public void run() {
		Table.printTable(100);
	}
}

class MyThread4 extends Thread {
	public void run() {
		Table.printTable(1000);
	}
}

public class StaticSynchronisation {
	public static void main(String t[]) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		t1.start();
		
		t2.start();
		t3.start();
		t4.start();
	}
}


