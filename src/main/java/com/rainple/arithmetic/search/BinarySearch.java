package com.rainple.arithmetic.search;

/**
 * 二叉查找法
 */
public class BinarySearch  {

    public static void main(String[] args) {
        System.out.println(search(467));
    }

    private static int search(int value) {
        int[] arr = new int[]{1,2,3,4,5,7,9,75,89,332,362,467,532};

        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            int mid = (right + left) / 2;
            int midValue = arr[mid];
            if (value > midValue) {
                left = mid + 1;
            }else if (value < midValue) {
                right = mid - 1;
            }else {
                return arr[mid];
            }
        }
        return -1;
    }

}
