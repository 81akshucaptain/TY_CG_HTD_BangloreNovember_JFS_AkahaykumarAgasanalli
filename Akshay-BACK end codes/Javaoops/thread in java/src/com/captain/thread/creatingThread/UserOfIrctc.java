package com.captain.thread.creatingThread;

public class UserOfIrctc extends Thread {
IRCTC i;

public UserOfIrctc(IRCTC i) {
	super();
	this.i = i;
}
public void run() {
	i.cinfirmTickets();
}
}
