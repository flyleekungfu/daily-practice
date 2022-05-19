package com.saltfish.dailypractice.concurrent.thread.poolcompleted;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池是否执行完成（CountDownLatch方式）
 * 优点：写法优雅，无需关闭线程池
 * 缺点：创建之后不能被重复使用，只能使用一次
 *
 * @author saltfish
 * @date 2022/4/8
 */
public class ThreadPoolCompleted2 {

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024));
        final int taskCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        // 添加任务
        for (int i = 0; i < taskCount; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                try {
                    // 随机休眠0-4s
                    int sleepTime = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("线程%s执行完成%n", finalI);
                // 线程执行完，计数器-1
                countDownLatch.countDown();
            });
        }
        try {
            // 阻塞等待线程池任务执行完
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程池执行完
        System.out.println();
        System.out.println("线程池执行完毕");
    }
}
