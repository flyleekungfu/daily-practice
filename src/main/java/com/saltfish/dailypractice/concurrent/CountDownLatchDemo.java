package com.saltfish.dailypractice.concurrent;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        // CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程1开始执行");
                Thread.sleep(3000);
                System.out.println("子线程1执行完毕");
                // latch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程2开始执行");
                Thread.sleep(3000);
                System.out.println("子线程2执行完毕");
                // latch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // try {
            System.out.println("等待两个子线程执行完毕...");
            // latch.await();
            System.out.println("两个子线程已经执行完毕，继续执行主线程");
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

    }
}
