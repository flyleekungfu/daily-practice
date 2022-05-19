package com.saltfish.dailypractice.concurrent.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试notify唤醒线程顺序
 */
public class NotifyExample {
    private static final List<String> waitList = new ArrayList<>(100);
    private static final List<String> notifyList = new ArrayList<>(100);

    public static void main(String[] args) {
        final Object lock = new Object();

        // 休眠100个线程
        for (int i = 0; i < 100; i++) {
            // 线程名
            String threadName = Integer.toString(i);
            new Thread(() -> {
                // 获取当前执行线程名称
                String currThreadName = Thread.currentThread().getName();
                synchronized (lock) {
                    // 存入等待list
                    waitList.add(currThreadName);
                    try {
                        // 休眠线程
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 存入唤醒list
                    notifyList.add(currThreadName);
                }
            }, threadName).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 唤醒100个线程
        for (int j = 0; j < 100; j++) {
            synchronized (lock) {
                // 唤醒线程
                lock.notify();
            }
        }

        // 打印线程列表
        System.out.println("等待线程顺序：" + waitList);
        System.out.println("唤醒线程顺序：" + notifyList);
    }
}
