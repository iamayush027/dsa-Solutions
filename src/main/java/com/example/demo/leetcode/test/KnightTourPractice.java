package com.example.demo.leetcode.test;

public class KnightTourPractice {
    static int totalMoves;
    static int[] rowPath = {2, 1, -1, -2, -2, -1, 2, 2};
    static int[] colPath = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        matrix[0][0] = 1;
        totalMoves = matrix.length * matrix[0].length;
        System.out.println(checkTour(0, 0, 1, matrix));
        displayMatrix(matrix);
    }

    private static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean checkTour(int row, int col, int moves, int[][] matrix) {
        if (moves == totalMoves) {
            return true;
        } else {
            for (int i = 0; i < rowPath.length; i++) {
                int newRow = row + rowPath[i];
                int newCol = col + colPath[i];
                if (isValid(newRow, newCol, matrix)) {
                    moves++;
                    matrix[newRow][newCol] = moves;
                    if (checkTour(newRow, newCol, moves, matrix)) {
                        return true;
                    }
                    moves--;
                    matrix[newRow][newCol] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == 0) {
            return true;
        }
        return false;
    }
}
