package com.example.demo.leetcode.test.dsa;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println(arr);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[0].length - 1; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                    //can use bitmasking as well to save the space.
                }
            }
        }
        for (int r : row) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[r][i] = 0;
        }
        for (int c : col) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][c] = 0;
        }
    }
}
