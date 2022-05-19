package com.saltfish.dailypractice.concurrent.thread.sleep;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSleepTest2 {

    public static void main(String[] args) throws InterruptedException {
        // 创建锁
        final Lock lock = new ReentrantLock();
        // 创建Condition
        final Condition condition = lock.newCondition();
        new Thread(() -> {
            System.out.println("线程执行：" + LocalDateTime.now());
            // 得到锁
            lock.lock();
            try {
                // 休眠线程
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 释放锁
                lock.unlock();
            }
            System.out.println("线程结束：" + LocalDateTime.now());
        }).start();
        Thread.sleep(1000);
        // 得到锁
        lock.lock();
        try {
            // 唤醒线程
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
