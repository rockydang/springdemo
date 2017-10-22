package com.rockydang.service.springdemo.service.concurrent.executor.completion;

import java.util.concurrent.*;

/**
 * Created by yanxiao on 2016/12/27.
 */
public class CompletionServiceExecutor {

    private final ExecutorService executor;

    CompletionServiceExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public void test() throws InterruptedException, ExecutionException {
        CompletionService completionService = new ExecutorCompletionService(executor);
        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            completionService.submit(new Callable() {
                @Override
                public String call() throws Exception {
                    return "call()方法被自动调用，任务返回的结果是" + Thread.currentThread().getName();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            Future<Integer> f = completionService.take();
//            Future<Integer> f = completionService.poll();
            System.out.println("f::" + f.get());
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionServiceExecutor completionServiceExecutor = new CompletionServiceExecutor(executorService);
        try {
            completionServiceExecutor.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}