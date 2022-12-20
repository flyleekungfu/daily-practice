package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * whenComplete测试
 * CompletableFuture 的 whenComplete 方法表示，某个任务执行完成后，执行的回调方法，无返回值；并且 whenComplete 方法返回的 CompletableFuture 的 result 是上个任务的结果。
 *
 */
public class WhenCompleteTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("进入线程：" + Thread.currentThread().getName());
            return "小明";
        });

        CompletableFuture<String> whenCompleteFuture = future.whenComplete((name, th) -> System.out.println("接收到" + name));
        System.out.println(whenCompleteFuture.get());
    }
}
