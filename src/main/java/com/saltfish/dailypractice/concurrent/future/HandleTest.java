package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * handle测试
 * CompletableFuture 的 handle 方法表示，某个任务执行完成后，执行回调方法，并且是有返回值的; 并且 handle 方法返回的 CompletableFuture 的 result 是回调方法执行的结果。
 *
 */
public class HandleTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "小明");
        CompletableFuture<String> handleFuture = future.handle((result, th) -> result + "进入班级");
        System.out.println(handleFuture.get());
    }
}
