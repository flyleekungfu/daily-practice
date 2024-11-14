package com.saltfish.dailypractice.cycle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 添加JVM参数：-XX:+PrintGCDetails -Xms4G -Xmx4G 观察for循环和stream的表现
 */
public class ForDemo {

    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(1, 10000000).boxed().collect(Collectors.toList());
        // 使用for循环
        // int sum = 0;
        // for (int i = 0; i < ids.size(); i++) {
        //     sum += ids.get(i);
        // }
        // 使用stream
        int sum = ids.stream().reduce(0, Integer::sum);
        System.gc();
    }
}
