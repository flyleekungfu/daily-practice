package com.saltfish.dailypractice.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        // 创建公平锁实现机制
        ReentrantLock lock = new ReentrantLock(true);

        // 创建5个线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("ThreadName：" + Thread.currentThread().getName() + "，启动了！");

                // 尝试获取锁
                lock.lock();

                try {
                    System.out.println("ThreadName：" + Thread.currentThread().getName() + "，获得锁！");
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
