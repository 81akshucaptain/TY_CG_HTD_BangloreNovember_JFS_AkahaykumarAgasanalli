package com.captain.thread.creatingThread;

public class ThreadEx1 extends Thread{
public void run() {
	for (int i = 0; i < 4; i++) {
		System.out.println(i);
	}
}
}
