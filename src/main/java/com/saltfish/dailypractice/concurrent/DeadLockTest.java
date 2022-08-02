package com.saltfish.dailypractice.concurrent;

public class DeadLockTest {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("线程1：获得锁A。");
                // 休眠 1s（让线程 2 有时间先占有锁 B）
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 2.获取线程 2 的锁 B
                synchronized (lockB) {
                    System.out.println("线程1：获得锁B。");
                }
            }
        });
        t1.start();

        // 创建线程 2
        Thread t2 = new Thread(() -> {
            // 1.占有锁 B
            synchronized (lockB) {
                System.out.println("线程2：获得锁B。");
                // 休眠 1s（保证线程 1 能有充足的时间得到锁 A）
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 2.获取线程 1 的锁 A
                synchronized (lockA) {
                    System.out.println("线程2：获得锁A。");
                }
            }
        });
        t2.start();
    }
}
