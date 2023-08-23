package com.example.demo.leetcode.test.FrogJump;

public class Solution {
    public static int maxJump(int[] stones) {
        int max = stones[1]-stones[0]; // If n == 2
        for(int i=2;i<stones.length;i++)
            max = Math.max(max,stones[i]-stones[i-2]);
        return max;
    }

    public static void main(String[] args) {
        int[] stones={0,2,5,6,7};
        System.out.println(maxJump(stones));
    }

}

