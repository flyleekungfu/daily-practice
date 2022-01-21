package com.saltfish.dailypractice.thread;

/**
 * ThreadLocal测试
 *
 * @author saltfish
 * @date 2021/5/7 19:48
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 6);
        System.out.println(threadLocal.get());
    }
}
