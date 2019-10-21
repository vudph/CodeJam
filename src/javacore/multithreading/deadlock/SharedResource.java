package javacore.multithreading.deadlock;

public class SharedResource {
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
