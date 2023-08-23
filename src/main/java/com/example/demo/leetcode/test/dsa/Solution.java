package com.example.demo.leetcode.test.dsa;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 4, 0, 1};
        int[] arr2 = {9, 9};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
        char[] s = {'h', 'e', 'l', 'l', 'o'};
//        System.out.println(isAnagram("nagaram", "anagram"));
        moveZeroes(arr);
//        System.out.println(reverse(123));
//        reverseString(s);
//        System.out.println(s);
//        int[] result = plusOne(arr2);
//        twoSum(arr, 7);
//        for (int i=0;i<3;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        rotate(matrix);
//        System.out.println("----------------");
//        for (int i=0;i<3;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println(singleNumber(arr2));
//        rotate(arr, 9);
//        System.out.println(containsDuplicate(arr));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (n < k) return;
        reverse(0, n - 1, arr);
        reverse(0, k - 1, arr);
        reverse(k, n - 1, arr);

    }

    public static void reverse(int start, int end, int[] arr) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public static int singleNumber(int[] nums) {
        int bitNum = 0;
        for (int i = 0; i < nums.length; i++) {
            bitNum = bitNum ^ nums[i];
        }
        return bitNum == 0 ? -1 : bitNum;
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {

            System.out.print(digits[i]);
            int value = digits[i] + add;
            result.add(value % 10);
            add = value / 10;
            if (i == 0 && add == 1) {
                result.add(1);
            }
        }
        System.out.println(result);
        Collections.reverse(result);
        int[] response = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            response[k] = result.get(k);
        }
        System.out.println(result);
        return response;
    }

    public static void moveZeroes(int[] nums) {
        int insertPosition = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition++] = nums[i];
            }

        }
        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(target - nums[i])) {
                return new int[]{nums[i], set.get(target - nums[i])};
            } else {
                set.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("----------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
        }
    }

    public static int reverse(int x) {
        long finalNum = 0;
        int multiplier = x < 0 ? -1 : 1;
        while (x != 0) {
            int num = x % 10;
            finalNum = finalNum * 10 + num;
            x = x / 10;
        }
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (multiplier * finalNum);
    }

    public static boolean isAnagram(String s, String t) {
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        Arrays.sort(arr_s);
        Arrays.sort(arr_t);
        s = new String(arr_s);
        t = new String(arr_t);
        return s.equals(t);


    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> arr = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[arr.size()];
        for (i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; i < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!seen.add(s + i) || !seen.add(j + s) || !seen.add(i / 3 + s + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int firstUniqChar(String s) {
        int num = 0;
        int ans = Integer.MAX_VALUE;
        for (char i = 'a'; i < 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                ans = Math.min(ans, index);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
private class ListNode{
        int val;
        ListNode next;
}



}
