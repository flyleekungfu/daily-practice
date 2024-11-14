package com.saltfish.dailypractice.concurrent.thread;

import java.util.concurrent.*;

/**
 * 多个线程顺序执行
 *
 */
public class SequentialExecutionTest {

    public static void main(String[] args) throws InterruptedException {
        // Thread thread1 = new Thread(() -> System.out.println("1"));
        // Thread thread2 = new Thread(() -> System.out.println("2"));
        // Thread thread3 = new Thread(() -> System.out.println("3"));

        // 无序执行
        // thread1.start();
        // thread2.start();
        // thread3.start();

        // 使用join
        // thread1.start();
        // thread1.join();
        // thread2.start();
        // thread2.join();
        // thread3.start();
        // thread3.join();

        // 使用CountDownLatch
        // countDownDemo();

        // 使用Semaphore
        // semaphoreDemo();

        // 单线程池
        // singleThreadExecutor();

        // CompletableFuture
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("1");
            sleep();
        });

        future = future.thenRunAsync(() -> {
            System.out.println("2");
            sleep();
        });

        future = future.thenRunAsync(() -> {
            System.out.println("3");
            sleep();
        });

        future.join();
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    private static void singleThreadExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> System.out.println("1"));
        executor.submit(() -> System.out.println("2"));
        executor.submit(() -> System.out.println("3"));
        executor.shutdown();
    }

    private static void semaphoreDemo() {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        Thread thread1 = new Thread(() -> {
            System.out.println("1");
            semaphore1.release();
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore1.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("2");
            semaphore2.release();
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void countDownDemo() {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            System.out.println("1");
            latch1.countDown();
        });

        Thread thread2 = new Thread(() -> {
            try {
                latch1.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("2");
            latch2.countDown();
        });

        Thread thread3 = new Thread(() -> {
            try {
                latch2.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
