package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * exceptionally 测试
 * CompletableFuture 的 exceptionally 方法表示，某个任务执行异常时，执行的回调方法; 并且有抛出异常作为参数，传递到回调方法。
 *
 */
public class ExceptionallyTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("进入CompletableFuture");
            throw new RuntimeException("未知异常");
        });
        CompletableFuture<Object> exceptionallyFuture = future.exceptionally((e) -> {
            e.printStackTrace();
            return "程序异常";
        });

        System.out.println(exceptionallyFuture.get());
    }
}
