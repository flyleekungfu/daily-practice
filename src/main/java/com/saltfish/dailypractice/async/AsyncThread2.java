package com.saltfish.dailypractice.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步线程2，使用线程池
 * <a href="https://juejin.cn/post/7165147306688249870">Java实现异步编程的8种方式</a>
 *
 */
public class AsyncThread2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> System.out.println("进入线程"));

        executorService.shutdown();
    }
}
