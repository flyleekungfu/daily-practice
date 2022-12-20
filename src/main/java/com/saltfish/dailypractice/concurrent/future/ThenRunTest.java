package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * thenRun测试
 *
 */
public class ThenRunTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个任务");
            return "第一个任务";
        });
        CompletableFuture<Void> thenRunFuture = future.thenRun(() -> System.out.println("第二个任务"));

        thenRunFuture.get();
    }
}
