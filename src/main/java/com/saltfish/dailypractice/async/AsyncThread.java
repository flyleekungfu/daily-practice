package com.saltfish.dailypractice.async;

/**
 * 异步线程
 * <a href="https://juejin.cn/post/7165147306688249870">Java实现异步编程的8种方式</a>
 *
 */
public class AsyncThread extends Thread{

    @Override
    public void run() {
        System.out.println("Current Thread:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        AsyncThread asyncThread = new AsyncThread();
        asyncThread.run();
    }
}
