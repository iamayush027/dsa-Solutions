package com.example.demo.leetcode.test;

public class BinaryWithPivot {
    public static void main(String[] args) {
        System.out.println(extracted());

    }

    private static int extracted() {

        int n = 3;
        int[] num = {3, 4, 5, 1, 2};
        int mid;
        int pivotIndex = 0;
        if (num.length % 2 == 0) {
            mid = num.length / 2;
        } else {
            mid = (num.length + 1) / 2;
        }
        int i = 0;
        while (i < num.length) {

            if (mid>0 && mid < num.length - 1 && (num[mid] > num[mid - 1] && num[mid] > num[mid + 1])) {
                pivotIndex = mid;
                break;
            }
            if (num[mid] < num[mid - 1]) {
                mid++;
            }
            if (mid < num.length - 1 && (num[mid] < num[mid + 1])) {
                mid--;
            }
            i++;
        }

        //got the pivot

        int sub1 = binarySearch(0, pivotIndex, num, n);
        int sub2 = binarySearch(pivotIndex, num.length, num, n);
        if (sub1 != -1) {
            return sub1;
        } else if (sub2 != -1) {
            return sub2;
        }
        return -1;

    }

    private static int binarySearch(int start, int end, int[] num, int element) {
        int mid = 0;
        if (num.length % 2 == 0) {
            mid = num.length / 2;
        } else {
            mid = (num.length + 1) / 2;
        }
        int i = 0;
        while (i < end) {

            if (num[mid] == element) {
                return mid;
            }
            if (num[mid] > element) {
                mid--;
            }
            if (num[mid] < element) {
                mid++;
            }
            if (mid >= end) {
                return -1;
            }
            i++;
        }
        return -1;
    }
}

/**
 * Given a binary string S, the task is to find the longest subsequence with an equal number of 0s and 1s and all the 0s are present before all the 1s.
 * Input: S = “0011001111”
 * 0010011011110101
 * Output: 8
 * <p>
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 */