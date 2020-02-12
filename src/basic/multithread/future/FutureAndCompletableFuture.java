package basic.multithread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class FutureAndCompletableFuture {
	
	public Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(1500);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    return completableFuture;
	}
	
	public void test1() throws InterruptedException, ExecutionException {
		Future<String> completableFuture = calculateAsync();
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("sum: " + sum);
		String result = completableFuture.get(); //block until complete
		System.out.println("==== result: " + result);
		
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("sum: " + sum);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureAndCompletableFuture ff = new FutureAndCompletableFuture();
		ff.test1();
		
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long-running Job
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        System.out.println("I'll run in a separate thread than the main thread.");
		    }
		});
		
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier() {
		    @Override
		    public Integer get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return 500;
		    }
		});

		// Block and wait for the future to complete
		future.get();
		
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("sum: " + (sum + future1.get()));
		
	}
}
