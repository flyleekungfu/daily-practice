package com.saltfish.dailypractice.concurrent.thread.wait;

/**
 * sleep加锁示例
 */
public class SleepDemo {
    private static final Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        SleepDemo sleepDemo = new SleepDemo();

        new Thread(() -> {
            synchronized (locker) {
                try {
                    System.out.println("sleep start");
                    Thread.sleep(1000);
                    System.out.println("sleep end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Thread.sleep(200);
        sleepDemo.doNotify();
    }

    private void doNotify() {
        synchronized (locker) {
            System.out.println("notify start");
            locker.notify();
            System.out.println("notify end");
        }
    }
}
