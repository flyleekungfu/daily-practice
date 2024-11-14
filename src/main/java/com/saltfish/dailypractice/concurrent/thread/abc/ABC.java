package com.saltfish.dailypractice.concurrent.thread.abc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 三个线程交替打印ABC
 *
 */
public class ABC {

    // 共享计数器
    private static int sharedCounter = 0;

    public static void main(String[] args) {
        // 打印的内容
        String printString = "ABC";
        // 定义循环栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        });
        // 执行任务
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < printString.length(); i++) {
                    synchronized (this) {
                        // 循环打印
                        sharedCounter = sharedCounter > 2 ? 0 : sharedCounter;

                        System.out.println(printString.toCharArray()[sharedCounter++]);
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

    }
}
