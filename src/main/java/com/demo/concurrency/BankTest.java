package com.demo.concurrency;

/**
 * @className: UnsynchBankTest
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/6
 **/
public class BankTest {
    public static final int NUM_ACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final int MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        SyncBankBySynchronized syncBank = new SyncBankBySynchronized(NUM_ACCOUNTS, INITIAL_BALANCE);
        for(int i = 0; i < NUM_ACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true){
                        int toAccount = (int)(syncBank.size()*Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        syncBank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(r).start();
        }
    }
}
