package com.captain.thread.creatingThread;

public class TestEx2 {
public static void main(String[] args) {
	ThreadEx2 t1=new ThreadEx2();
	//it wont have any start method in runnable hence,,..
	//hence pass the object into Thread constructor...,
	System.out.println("main started");
	Thread t=new Thread(t1);
	t.start();
	System.out.println("main ended");
}
}
