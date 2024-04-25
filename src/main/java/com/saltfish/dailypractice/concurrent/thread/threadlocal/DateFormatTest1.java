package com.saltfish.dailypractice.concurrent.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal解决DateFormat线程安全问题
 */
public class DateFormatTest1 {

    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = DATE_FORMAT_THREAD_LOCAL.get().parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> System.out.println(parse("2024-04-02 14:03:00")));
        }
        executorService.shutdown();
    }
}
