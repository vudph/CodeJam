package javacore.multithreading.states;

public class ThreadInBlocked {//Deadlock
	public static void main(String[] args) {
		SharedResource s1 = new SharedResource();
		SharedResource s2 = new SharedResource();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				s1.methodOne(s2);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				s2.methodTwo(s1);
			}
		});
		t1.start();
		t2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t1.getState());     //Output : BLOCKED
        System.out.println(t2.getState());     //Output : BLOCKED
	}
	
	static class SharedResource {
		public synchronized void methodOne(SharedResource s) {
			Thread t = Thread.currentThread();
			System.out.println(t.getName() + " is executing methodOne...");
			System.out.println(t.getName() + " is calling methodTwo...");
			s.methodTwo(this);
			System.out.println(t.getName() + " is finished executing methodOne...");
		}
		
		public synchronized void methodTwo(SharedResource s) {
			Thread t = Thread.currentThread();
	        System.out.println(t.getName()+" is executing methodTwo...");
	        System.out.println(t.getName()+" is calling methodOne...");
	        s.methodOne(this);
	        System.out.println(t.getName()+" is finished executing methodTwo...");
		}
	}
}


