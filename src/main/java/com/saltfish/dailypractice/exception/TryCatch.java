package com.saltfish.dailypractice.exception;

public class TryCatch {

    public static void main(String[] args) {
        tryInsideCensus();
    }

    public static void tryOutside() {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 3) {
                    // 制造异常
                    int j = i / 0;
                }
                System.out.println("第" + i + "个业务正常执行");
            }
        } catch (Exception e) {
            System.out.println("try catch在for循环外，出现异常时for循环中断");
        }
    }

    public static void tryInside() {
        for (int i = 0; i < 5; i++) {
            try {
                if (i == 3) {
                    // 制造异常
                    int j = i / 0;
                }
                System.out.println("第" + i + "个业务正常执行");
            } catch (Exception e) {
                System.out.println("try catch在for循环内，出现异常时for循环继续执行");
            }
        }
    }

    public static void tryInsideCensus() {
        long beginTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        for (int i = 0; i < 300000; i++) {
            try {
                if (i > 2) {
                    // 制造异常
                    int j = i / 0;
                }
                System.out.println("第" + i + "个业务正常执行");
            } catch (Exception e) {
                System.out.println("捕获异常");
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        System.out.println((freeMemory - runtime.freeMemory()) / 10000 + "W");
    }
}
