package com.demo.concurrency;

import javax.crypto.Cipher;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: CounterDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/25
 **/

class Counter{
    private int count;
    private final Lock lock = new ReentrantLock();
    //通过synchronized
//    public synchronized void increase(){
//        count++;
//    }
//
//    public synchronized int getCount(){
//        return count;
//    }

    //通过ReentrantLock
    public void increase(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}


class CounterThread extends Thread {
    Counter counter;
    public CounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.increase();
        }
    }
}

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException{
        int threadNum = 1000;
        Counter counter = new Counter();
        Thread [] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; i++){
            threads[i] = new CounterThread(counter);
        }
        for(int i = 0; i < threadNum; i++){
            threads[i].start();
            threads[i].join();
        }

        System.out.println(counter.getCount());
    }
}
