package com.example.demo.leetcode.test.dsa;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 27));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col <matrix.length) {
            if (matrix[row][col] == target) return true;
            else if (row != 0 && matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    private static boolean check(int[][] matrix, int row, int col, int target) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) return false;
        if (matrix[row][col] == target) return true;
        else if (matrix[row][col] > target) {
            return check(matrix, row - 1, col, target) || check(matrix, row, col - 1, target);
        } else {
            return check(matrix, row + 1, col, target) || check(matrix, row, col + 1, target);

        }
    }
}
