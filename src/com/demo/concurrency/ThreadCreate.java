package com.demo.concurrency;

/**
 * @author fuguo
 * @date 2021/11/05 6:13 下午
 */

class createByThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("通过继承Thread类并重写run方法，创建线程");
    }
}
class createByRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("通过实现Runnable接口并重写run方法，创建线程");
    }
}

public class ThreadCreate {
    public static void main(String[] args) {
        createByThread byThread = new createByThread();
        byThread.start();

        Thread byRunnable = new Thread(new createByRunnable());
        byRunnable.start();
    }
}
