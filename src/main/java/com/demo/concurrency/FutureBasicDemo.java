package com.demo.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @className: FutureBasicDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/26
 **/
public class FutureBasicDemo {
    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Task());

        //模拟执行其他任务
        Thread.sleep(100);
        try {
            System.out.println(future.get());
        }
        catch (ExecutionException e){
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
