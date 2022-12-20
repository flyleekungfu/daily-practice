package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * thenApply测试
 *
 */
public class ThenApplyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "小明");
        CompletableFuture<String> thenApplyFuture = future.thenApply((a) -> a + "进入班级");

        System.out.println(thenApplyFuture.get());
    }
}
