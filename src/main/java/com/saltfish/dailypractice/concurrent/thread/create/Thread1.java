package com.saltfish.dailypractice.concurrent.thread.create;

public class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        Thread1 thread3 = new Thread1();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
