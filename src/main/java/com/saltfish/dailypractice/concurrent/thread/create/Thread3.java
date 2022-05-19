package com.saltfish.dailypractice.concurrent.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Thread3 implements Callable<String> {

    @Override
    public String call() {
        int count = 20;
        for (int i = count; i > 0; i--) {
//			Thread.yield();
            System.out.println(Thread.currentThread().getName()+"当前票数：" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) {
        Thread3 thread = new Thread3();
        FutureTask<String> futureTask = new FutureTask<>(thread);
        Thread thread1 = new Thread(futureTask, "线程1");
        Thread thread2 = new Thread(futureTask, "线程2");
        Thread thread3 = new Thread(futureTask, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
