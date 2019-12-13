package com.captain.thread.creatingThread;

public class IRCTC {
 synchronized void cinfirmTickets() {
	for (int i = 0; i < 4; i++) {
		//REMOVE SYNCHRONISED key word to act specially i,.e simultaneously executions 
		//if we made method as synchronised then
		//it would block the other thread to executed
		System.out.println(i);
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			wait();
			//always callin the synchronized method
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
 synchronized void leaveMe() {
	 System.out.println("leave me called");
	 //notify(); only one method is released
	 notifyAll();
 }
}
