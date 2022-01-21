package com.saltfish.dailypractice.collection;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 弱hashMap测试
 *
 * @author saltfish
 * @date 2021/5/28 14:28
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        Map<String, String> weakHashMap = new WeakHashMap<>(4);

        for (int i = 0, size = 3; i < size; i++) {
            weakHashMap.put("key-" + i, "value-" + i);
        }

        System.out.println("map大小：" + weakHashMap.size() + "，map值：" + weakHashMap);

        System.out.println("------进行垃圾回收------");
        System.gc();

        System.out.println("map大小：" + weakHashMap.size() + "，map值：" + weakHashMap);
    }
}

