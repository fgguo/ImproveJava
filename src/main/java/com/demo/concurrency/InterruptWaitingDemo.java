package com.demo.concurrency;

/**
 * @className: InterruptWaitingDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/24
 **/
public class InterruptWaitingDemo extends Thread {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                System.out.println(interrupted());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //清理操作
                //重设中断标志位
                Thread.currentThread().interrupted();
                return;
            }
        }
        System.out.println(isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptWaitingDemo();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

    }
}
