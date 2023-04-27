package com.saltfish.dailypractice.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Future异步
 * <a href="https://juejin.cn/post/7165147306688249870">Java实现异步编程的8种方式</a>
 *
 */
@Slf4j
public class FutureManger {

    public String execute() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> {
            System.out.println(" --- task start ---");
            Thread.sleep(3000);
            System.out.println(" --- task end ---");
            return "this is future execute final result!!!";
        });

        String result = future.get();
        executorService.shutdown();
        log.info("future get result:" + result);
        return result;
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureManger futureManger = new FutureManger();
        futureManger.execute();
    }
}
