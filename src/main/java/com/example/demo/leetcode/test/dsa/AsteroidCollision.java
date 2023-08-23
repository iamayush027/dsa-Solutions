package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 1, -2};
        int[] result = asteroidCollision(arr);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {

        List<Integer> list = new ArrayList<>();

        return isCollide(asteroids, false);

    }

    private static int[] isCollide(int[] asteroids, boolean isCollide) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (Math.abs(asteroid) > Math.abs(st.peek())) {
                    st.pop();
                    continue;
                } else if (Math.abs(asteroid) == Math.abs(st.peek())) {
                    st.pop();
                }
                flag = false;
                break;
            }
            if (flag) st.push(asteroid);
        }
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;

    }
}
