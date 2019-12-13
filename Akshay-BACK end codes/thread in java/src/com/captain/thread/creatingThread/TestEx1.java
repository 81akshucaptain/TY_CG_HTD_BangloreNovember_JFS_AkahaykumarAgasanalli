package com.captain.thread.creatingThread;

public class TestEx1 {
public static void main(String[] args) {
	System.out.println("main started..");
	ThreadEx1 t1=new ThreadEx1();
	ThreadEx1 t2=new ThreadEx1();
//USED TO CALL THE RUN INTERNALLY, TO TURN RUNABLE TO RUNNING..:
	t1.start();

	System.out.println("main ended");
	
}
}
