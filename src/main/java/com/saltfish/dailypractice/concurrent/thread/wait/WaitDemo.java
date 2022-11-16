package com.saltfish.dailypractice.concurrent.thread.wait;

/**
 * wait加锁示例
 */
public class WaitDemo {

    private static final Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {

        WaitDemo waitDemo = new WaitDemo();

        // 启动新线程，防止主线程被休眠
        new Thread(() -> {
            try {
                waitDemo.doWait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // 此行本身没有意义，是为了确保wait()先执行再执行notify()
        Thread.sleep(200);

        waitDemo.doNotify();
    }

    /**
     * 执行notify()
     */
    private void doNotify() {
        synchronized (locker) {
            System.out.println("notify start");
            locker.notify();
            System.out.println("notify end");
        }
    }

    /**
     * 执行wait()
     */
    private void doWait() throws InterruptedException {
        synchronized (locker) {
            System.out.println("wait start");
            locker.wait();
            System.out.println("wait end");
        }
    }
}
