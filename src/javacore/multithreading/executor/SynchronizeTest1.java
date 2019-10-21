package javacore.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizeTest1 {
	private static final int NUM_INCREMENTS = 10;

	public static void main(String[] args) {
		testNonSyncIncrement();
//		testSyncIncrement();
	}
	
	private static void testNonSyncIncrement() {
		SharedResource s = new SharedResource();
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable task = () -> {
		    s.increment();
		};
		
		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(task));

		ConcurrentUtils.stop(executor);

		System.out.println("NonSync: " + s.getCount1());
	}
	
	private static void testSyncIncrement() {
		SharedResource s = new SharedResource();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable task = () -> {
		    s.incrementSync();
		};

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(task));

		ConcurrentUtils.stop(executor);

		System.out.println("Sync: " + s.getCount2());
	}

	
}
