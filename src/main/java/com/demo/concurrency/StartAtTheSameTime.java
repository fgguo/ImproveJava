package com.demo.concurrency;

/**
 * @className: StartAtTheSameTime
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/24
 **/
public class StartAtTheSameTime {

    /*
    同时开始，类似于运动员比赛，在听到比赛开始枪响后同时开始，
    这里，有一个主线程和N个子线程，每个子线程模拟一个运动员，主线程模拟裁判，它们协作的共享变量是一个开始信号。
    用一个类FireFlag来表示这个协作对象
    * */
    static class FireFlag{
        private volatile boolean fired = false;
        public synchronized void waitForFire() throws InterruptedException{
            while(!fired){
                wait();
            }
        }
        public synchronized void fire(){
            this.fired = true;
            notifyAll();
        }
    }

    static class Racer extends Thread{
        FireFlag fireFlag = null;

        public Racer(FireFlag fireFlag){
            this.fireFlag = fireFlag;
        }
        @Override
        public void run() {
            try {
                this.fireFlag.waitForFire();
                System.out.println(Thread.currentThread().getName()+"start run");
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FireFlag flag = new FireFlag();
        int num = 10;
        Thread [] racers = new Thread[num];
        for(int i = 0; i < num; i++){
            racers[i] = new Racer(flag);
            racers[i].start();
        }
        Thread.sleep(1000);
        flag.fire();
    }
}
