/**
 * 认识future
 */
package com.rockydang.service.springdemo.common.concurrent.yxxy.c_026;

import java.util.concurrent.*;

public class T06_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> task = new FutureTask<>(()->{
			TimeUnit.MILLISECONDS.sleep(500);
			return 1000;
		}); //new Callable () { Integer call();}
		
		new Thread(task).start();
		
		System.out.println(task.get()); //阻塞
		
		//*******************************
		ExecutorService service = Executors.newFixedThreadPool(5);
//		ExecutorService service = new ThreadPoolExecutor(4,32,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(500));
		Future<Integer> f = service.submit(()->{
			TimeUnit.MILLISECONDS.sleep(500);
			return 1;
		});
		System.out.println(f.get());
		System.out.println(f.isDone());
		
	}
}
