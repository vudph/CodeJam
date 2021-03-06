package javacore.multithreading.join;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("In main() method");
		MyRunnable1 runnable1 = new MyRunnable1();
		MyRunnable2 runnable2 = new MyRunnable2();
		Thread thread1 = new Thread(runnable1);
		thread1.setName("thread 1");
		Thread thread2 = new Thread(runnable1);
		thread2.setName("thread 2");
		Thread thread3 = new Thread(runnable2);
		thread3.setName("thread 3");
		Thread thread4 = new Thread(runnable2);
		thread4.setName("thread 4");
		
		thread1.start();
		thread1.join(); //Waits for this thread to die

		thread3.start();
		thread3.join();

		thread2.start();
		thread2.join();
		
		thread4.start();
		thread4.join();
		
		System.out.println("end main() method");
	}

}
