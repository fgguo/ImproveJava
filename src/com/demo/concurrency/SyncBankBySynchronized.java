package com.demo.concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fuguo
 * @date 2021/11/06 4:59 下午
 */
public class SyncBankBySynchronized {
    private final double [] accounts;

    private Lock bankLock;

    /**

     * @param n 账号数
     * @param initialBalance 账户初始余额
     * @description: 构造器
     * @return:
     * @author: fuguo
     * @date: 2021/11/6
     */
    public SyncBankBySynchronized(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }
    /**
     * @param from 转账发起方
     * @param to 收款方
     * @param amount 转账金额
     * @description: 两个账号之间的转账
     * @return: void
     * @author: fuguo
     * @date: 2021/11/6
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{

        while (accounts[from] < amount) wait();
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("transfer %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance : %10.2f %n", getBalance());
        notifyAll();
    }

    /**
     * @description: 计算当前所有账户余额的总和
     * @return: 账号余额
     * @author: fuguo
     * @date: 2021/11/6
     */
    public synchronized double getBalance(){
        double sum = 0;
        for (double balance : accounts) {
            sum += balance;
        }
        return sum;
    }
    /**
     * @description: 获取账户数
     * @return: 账户数量
     * @author: fuguo
     * @date: 2021/11/6
     */
    public int size(){
        return accounts.length;
    }

}
