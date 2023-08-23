package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSeqScore {


    public static void main(String[] args) {
        int[] num1 = {1, 3, 3, 2};
        int[] num2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(num1, num2, k));

    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            queue.offer(arr[i][0]);
            sum += arr[i][0];
            if (i >= k) {
                sum -= queue.poll();
            }
            if (i >= k - 1) {
                ans = Math.max(ans, (long) sum * arr[i][1]);
            }

        }
        return ans;
    }


}


/**
 * var n = nums1.length;
 *     var arr = new int[n][2];
 *
 *     for (var i=0; i<n; i++)
 *       arr[i] = new int[] {nums1[i], nums2[i]};
 *
 *     Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
 *
 *     long ans = 0, sum = 0;
 *     var heap = new PriorityQueue<Integer>();
 *
 *     for (var i=0; i<n; i++) {
 *       heap.offer(arr[i][0]);
 *       sum += arr[i][0];
 *
 *       if (i >= k)
 *         sum -= heap.poll();
 *
 *       if (i >= k-1)
 *         ans = Math.max(ans, sum * arr[i][1]);
 *     }
 *     return ans;
 *
 */