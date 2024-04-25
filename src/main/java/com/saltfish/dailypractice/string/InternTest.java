package com.saltfish.dailypractice.string;
public class InternTest {
    public static void main(String[] args) {
        String s1 = new StringBuilder("dasddas").append("dads").toString();
        String s11 = s1.intern();
        System.out.println(s1);
        System.out.println(s11);
        System.out.println(s1 == s11);

        String s2 = new StringBuilder("ja").append("va").toString();
        String s22 = s2.intern();
        System.out.println(s2);
        System.out.println(s22);
        System.out.println(s2 == s22);
    }
}
