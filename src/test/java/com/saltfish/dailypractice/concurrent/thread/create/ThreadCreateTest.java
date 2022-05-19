package com.saltfish.dailypractice.concurrent.thread.create;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadCreateTest {

    @Test
    public void testThreadCreate1() {
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        Thread1 thread3 = new Thread1();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Test
    public void testThreadCreate2() {
        Thread2 thread = new Thread2();
        Thread thread1 = new Thread(thread, "线程1");
        Thread thread2 = new Thread(thread, "线程2");
        Thread thread3 = new Thread(thread, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Test
    public void testThreadCreate3() {
        Thread3 thread = new Thread3();
    }
}
