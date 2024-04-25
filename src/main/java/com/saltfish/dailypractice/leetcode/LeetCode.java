package com.saltfish.dailypractice.leetcode;

public class LeetCode {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] twoSumRes = twoSum.twoSum1(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < twoSumRes.length; i++) {
            System.out.println(twoSumRes[i]);
        }
    }
}
