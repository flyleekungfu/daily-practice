package com.saltfish.dailypractice.concurrent.thread.sleep;

import java.util.concurrent.locks.LockSupport;

public class ThreadSleepTest3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("线程1休眠");
            // 休眠线程
            LockSupport.park();
            System.out.println("线程1执行结束");
        }, "线程1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("线程2休眠");
            // 休眠线程
            LockSupport.park();
            System.out.println("线程2执行结束");
        }, "线程2");
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("唤醒线程1");
            // 唤醒线程1
            LockSupport.unpark(t1);
        }, "线程3");
        t3.start();
    }
}
