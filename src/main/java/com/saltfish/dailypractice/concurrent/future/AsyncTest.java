package com.saltfish.dailypractice.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建异步任务
 *
 */
public class AsyncTest {

    public static void main(String[] args) {
        // 可以自定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // runAsync使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("测试runAsync"), executorService);

        // supplyAsync使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("测试supplyAsync");
            return "测试supplyAsync";
        }, executorService);

        // runAsync的future没有返回值，返回null
        System.out.println(runFuture.join());
        // supplyAsync的future有返回值
        System.out.println(supplyFuture.join());
        executorService.shutdown();
    }
}
