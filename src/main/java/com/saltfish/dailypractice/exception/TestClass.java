package com.saltfish.dailypractice.exception;

public class TestClass {
    private static int len = 779;
    public int add(int x){
        try {
            // 若运行时检测到 x = 0,那么 jvm会自动抛出异常，(可以理解成由jvm自己负责 athrow 指令调用)
            x = 100/x;
        } catch (Exception e) {
            x = 100;
        }
        return x;
    }
}
