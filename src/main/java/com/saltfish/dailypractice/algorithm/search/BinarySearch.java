package com.saltfish.dailypractice.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {

    }

    public static Integer binarySearch() {
        int[] arr = {1, 2, 3, 4, 5};

        int target = 4;
        int i = arr.length / 2;
        int elMiddle = arr[i];

        if (target == elMiddle) {
            return i;
        }

        if (target >= elMiddle) {
            // 右边查找，2、3、4
            int startIndex = arr.length - i + 1;
        } else {
            // 左边查找
        }

        return null;
    }

    public static Integer myBinarySearch(int arr[], int target, int startIndex, int endIndex) {
        // 2,3,4
        // int middleIndex = startIndex = ((endIndex - startIndex + 1) / 2);
        // int middleEl = arr[middleIndex];
        // if (middleEl == target) {
        //
        // }
        return 0;
    }
}
