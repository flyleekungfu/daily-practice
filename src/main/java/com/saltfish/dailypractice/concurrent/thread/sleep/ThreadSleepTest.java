package com.saltfish.dailypractice.concurrent.thread.sleep;


import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 线程休眠测试
 */
public class ThreadSleepTest {

    public static void main(String[] args) {
        // 第一种休眠方式：Thread.sleep(1000);
        //sleep1();

        // 第二种休眠方式：TimeUnit.SECONDS.sleep(1);
        //sleep2();

        // 第三种休眠方式：
        sleep3();
    }

    private static void sleep3() {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    // 让当前线程休眠
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        synchronized (lock) {
            lock.notify(); // 唤醒当前对象上一个休眠线程
            // lock.notifyAll(); // 唤醒当前对象上所有休眠的线程
        }
    }

    private static void sleep2() {
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2执行：" + LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2结束：" + LocalDateTime.now());
        });
        thread2.start();
    }

    private static void sleep1() {
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1执行：" + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程1结束：" + LocalDateTime.now());
        });
        thread1.start();
    }
}
