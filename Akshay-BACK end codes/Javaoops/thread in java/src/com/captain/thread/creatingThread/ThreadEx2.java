package com.captain.thread.creatingThread;

public class ThreadEx2 implements Runnable {
//ONLY ONE METHOD PRESENT IN RUNNABLE IS run()
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
		}		
	}

}
