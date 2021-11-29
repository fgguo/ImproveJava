package com.demo.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: AutomicIntegerDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/25
 **/
public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger(0);

    static class Vistor extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int threadNum = 1000;
        Thread [] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new Vistor();
        }
        for(int i = 0; i < threadNum; i++){
            threads[i].start();
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
