package com.saltfish.dailypractice.interview.largefactoryinterview;

/**
 * StringIntern测试
 *
 */
public class StringIntern {

    public static void main(String[] args) {
        String str = "测试";
        System.out.println(str);
        System.out.println(str.intern());
        System.out.println(str.equals(str.intern()));

        String str2 = "java";
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2.equals(str2.intern()));
    }
}
