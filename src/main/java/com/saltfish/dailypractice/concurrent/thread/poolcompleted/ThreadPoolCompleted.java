package com.saltfish.dailypractice.concurrent.thread.poolcompleted;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行完成测试
 *
 * @author saltfish
 * @date 2022/4/8
 */
public class ThreadPoolCompleted {

    public static void main(String[] args) {
        // 1.创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024));
        // 2.添加任务
        addTask(threadPool);
        // 3.判断线程池是否执行完
        isCompletedByTaskCount(threadPool);
        // 4.打印结果
        System.out.println();
        System.out.println("线程池任务执行完成");
    }

    /**
     * 判断线程池是否执行完
     * 缺点：需要关闭线程池
     * @param threadPool 线程池
     */
    private static void isCompleted(ThreadPoolExecutor threadPool) {
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            // 如果没有执行完成就一直循环
        }
    }

    /**
     * 根据线程池任务数判断线程池是否执行完毕
     * 优点：无需关闭线程池
     * 缺点：getTaskCount() 和 getCompletedTaskCount() 返回的是一个近似值，因为线程池中的任务和线程的状态可能在计算过程中动态变化，所以它们两个返回的都是一个近似值。
     * @param threadPool 线程池
     */
    private static void isCompletedByTaskCount(ThreadPoolExecutor threadPool) {
        while (threadPool.getTaskCount() != threadPool.getCompletedTaskCount()) {

        }
    }

    /**
     * 给线程池添加任务
     * @param threadPool 线程池
     */
    private static void addTask(ThreadPoolExecutor threadPool) {
        // 任务总数
        final int taskCount = 5;
        // 添加任务
        for (int i = 0; i < taskCount; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                try {
                    // 随机休眠 0-4s
                    int sleepTime = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("任务%s执行完成%n", finalI);
            });
        }
    }
}
