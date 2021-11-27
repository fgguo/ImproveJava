package com.demo.concurrency;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @className: ScheduledDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/27
 **/
public class ScheduledDemo {
    static class LongRunningTast extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("结束任务");
        }
    }

    static class FixedDelayTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(10);
        timer.schedule(new LongRunningTast(),10, TimeUnit.MILLISECONDS);

        timer.scheduleWithFixedDelay(new FixedDelayTask(),100,1000,TimeUnit.MILLISECONDS);


    }
}
