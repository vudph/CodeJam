package javacore.multithreading.stopthread;

public class TestStopThread {

	public static void main(String[] args) {
//		ThreadStopVolatile t1 = new ThreadStopVolatile();
//		t1.start();
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		t1.stopThread();
		
		ThreadInterrupt t2 = new ThreadInterrupt();
		t2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.interrupt();
	}

}
