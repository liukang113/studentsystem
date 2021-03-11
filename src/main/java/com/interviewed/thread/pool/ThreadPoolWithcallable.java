package com.interviewed.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolWithcallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(4); 
		
		for(int i = 0; i < 10; i++){
			Future<String> submit = pool.submit(new Callable<String>(){
				@Override
				public String call() throws Exception {
					//System.out.println("a");
					return "b";
				}			   
			   });
			System.out.println(submit.get());
		} 
			pool.shutdown();

	}

}
