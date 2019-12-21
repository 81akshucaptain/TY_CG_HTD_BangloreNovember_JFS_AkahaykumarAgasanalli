package com.captain.thread.creatingThread;

public class TestIrctc {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i1=new IRCTC();

		UserOfIrctc u1=new UserOfIrctc(i1);
		u1.start();
		UserOfIrctc u2=new UserOfIrctc(i1);
		u2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i1.leaveMe();
		System.out.println("main ended");
	}
}
