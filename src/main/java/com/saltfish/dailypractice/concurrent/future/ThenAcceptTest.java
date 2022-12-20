package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ThenAccept测试
 * CompletableFuture 的 thenAccept 方法表示，第一个任务执行完成后，执行第二个回调方法任务，会将该任务的执行结果，作为入参，传递到回调方法中，但是回调方法是没有返回值的。
 */
public class ThenAcceptTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("第一个方法");
            return "小明";
        });

        CompletableFuture<Void> thenAcceptFuture = completableFuture.thenAccept((result) -> System.out.println(result + "进入班级"));

        System.out.println(thenAcceptFuture.get());
    }
}
