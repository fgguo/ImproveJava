package com.demo.concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: CooperationDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/24
 **/


public class ProducerAndConsumer {
    //在生产者/消费者模式中，协作的共享变量是队列，生产者往队列上放数据，
    // 如果满了就wait，而消费者从队列上取数据，如果队列为空也wait。

    //通过显示锁和条件变量实现阻塞队列
    static class MyBlockingQueue<E>{
        private Lock lock = new ReentrantLock();
        private int limit;
        private Queue<E> queue = null;
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();

        public MyBlockingQueue(int limit){
            this.limit = limit;
            queue = new ArrayDeque<>(limit);
        }

        public void put(E e) throws InterruptedException{
            lock.lock();
            try {
                while (queue.size() == limit){
                    notFull.await();
                }
                queue.add(e);
                notEmpty.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException{
            lock.lock();
            try {
                while(queue.isEmpty()){
                    notEmpty.await();
                }
                E e = queue.poll();
                notFull.signalAll();
                return e;
            }
            finally {
                lock.unlock();
            }
        }
    }

    //通过synchronized
//    static class MyBlockingQueue<E> {
//        private Queue<E> queue = null;
//        private int limit;
//        public  MyBlockingQueue(int limit){
//            this.limit = limit;
//            queue = new ArrayDeque<>(limit);
//        }
//        public synchronized void put(E e) throws InterruptedException{
//            while (queue.size() == limit){
//                wait();
//            }
//            queue.add(e);
//            notifyAll();
//        }
//
//        public synchronized E take() throws InterruptedException{
//            while (queue.isEmpty()){
//                wait();
//            }
//            E e = queue.poll();
//            notifyAll();
//            return e;
//        }
//    }

    //生产者

    static class Producer extends Thread{
        MyBlockingQueue<String> queue;
        public Producer(MyBlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (true) {
                    String task = String.valueOf(num);
                    queue.put(task);
                    System.out.println("produce task " + task);
                    num++;
                    Thread.sleep((int)Math.random()*1000);
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class Consumer extends Thread{
        MyBlockingQueue<String> queue;
        public Consumer(MyBlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true){
                    String task = queue.take();
                    System.out.println("consumer task " + task);
                    Thread.sleep((int)Math.random()*1000);
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(20);
        new Producer(queue).start();
        new Consumer(queue).start();

    }
}
