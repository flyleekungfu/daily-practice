package com.saltfish.dailypractice.concurrent.future.taskorchestrator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用 Future 实现上述 4 个任务的编排（任务二要等任务一执行完才能执行，而任务四要等任务二和任务三全部执行完才能执行）：
 */
public class TaskOrchestrator {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<String> taskOneResult = executor.submit(() -> {
            Thread.sleep(2000);
            return "Task One Result";
        });

        Future<String> taskTwoResult = executor.submit(() -> {
            String result = taskOneResult.get();
            Thread.sleep(1000);
            return "Task Two Result, got: " + result;
        });

        Future<String> taskThreeResult = executor.submit(() -> {
            Thread.sleep(1500);
            return "Task Three Result";
        });

        Future<String> taskFourResult = executor.submit(() -> {
            String taskTwoOutput = taskTwoResult.get();
            String taskThreeOutput = taskThreeResult.get();
            Thread.sleep(500);
            return "Task Four Result, got: " + taskTwoOutput + " and " + taskThreeOutput;
        });

        try {
            System.out.println("Final Result: " + taskFourResult.get());
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
