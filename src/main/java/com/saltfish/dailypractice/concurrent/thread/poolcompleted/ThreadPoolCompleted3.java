package com.saltfish.dailypractice.concurrent.thread.poolcompleted;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池是否执行完成（CyclicBarrier 方式）
 *
 *
 * @author saltfish
 * @date 2022/4/8
 */
public class ThreadPoolCompleted3 {

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024));
        final int taskCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(taskCount, () -> {
            // 线程池执行完
            System.out.println();
            System.out.println("线程池所有任务已执行完！");
        });
        // 添加任务
        for (int i = 0; i < taskCount; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                try {
                    // 随机休眠0-4s
                    int sleepTime = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(sleepTime);
                    System.out.printf("线程%s执行完成%n", finalI);
                    // 线程执行完
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
