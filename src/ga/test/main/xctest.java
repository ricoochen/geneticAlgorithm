package ga.test.main;

import java.util.*;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;


public class xctest {

	public static class TaskCallable implements Callable<String>{
	    private int id;
	    public TaskCallable(int id){
	        this.id = id;
	    }
	    @Override
	    public String call() throws Exception {
	        String str = "Number" + String.valueOf(id) + "thread " + String.valueOf(Thread.currentThread().getName()) + " is called";
	        System.out.println(str);
	        Thread.sleep(1000);
	        String str1 = "Number" + String.valueOf(id) + "thread " + String.valueOf(Thread.currentThread().getName()) + " is awake";
	        System.out.println(str1);
	        return String.valueOf(id);
	    }
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(10);
		RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
		ExecutorService threadPool = new ThreadPoolExecutor(10, 110, 0L, TimeUnit.MILLISECONDS,workingQueue, rejectedExecutionHandler);
        @SuppressWarnings("unused")
		CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);

		
		for (int i = 0; i < 150; i++) {
			// Future<String> future 
			 completionService.submit(new TaskCallable(i));
//			@SuppressWarnings("unused")
//			Future<String>	results = threadPool.submit(new TaskCallable(i));
//			results.get();
		}

        String temp = null;
        for(int i=0;i<150;i++){
            temp = completionService.take().get();
            System.out.println(temp);
        }

		threadPool.shutdown();
		//results.get();
		System.out.println("main program working end");
	}

}
