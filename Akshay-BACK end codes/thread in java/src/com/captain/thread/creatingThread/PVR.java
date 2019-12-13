package com.captain.thread.creatingThread;

public class PVR {
	synchronized public void confirmTickets() {
		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//we must write wait() method in SYNCHRONIZED method,else IlligalMonitorState
			//check red light on right top
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
synchronized void leaveMe() {
	System.out.println("notify called");
		notify();
	}
}
