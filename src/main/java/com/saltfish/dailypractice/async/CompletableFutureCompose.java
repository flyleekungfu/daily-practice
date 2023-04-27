package com.saltfish.dailypractice.async;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture异步
 * <a href="https://juejin.cn/post/7165147306688249870">Java实现异步编程的8种方式</a>
 *
 */
public class CompletableFutureCompose {

    /**
     * thenAccept子任务和父任务公用同一个线程
     */
    @SneakyThrows
    public static void thenRunAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something...");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> System.out.println(" cf2 do something..."));

        // 等待任务1完成
        System.out.println("cf1结果->" + cf1.get());
        // 等待任务2完成
        System.out.println("cf2结果->" + cf2.get());
    }

    public static void main(String[] args) {
        thenRunAsync();
    }
}
