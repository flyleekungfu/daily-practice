package com.saltfish.dailypractice.concurrent.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat线程安全问题
 */
public class DateFormatTest {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            System.out.println("解析时间字符串：" + dateStr);
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                System.out.println(parse("2024-04-02 13:49:00"));
            });
        }
        executorService.shutdown();
    }
}
