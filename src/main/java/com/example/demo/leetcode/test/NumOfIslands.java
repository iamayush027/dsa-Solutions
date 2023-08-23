package com.example.demo.leetcode.test;

public class NumOfIslands {
    public static void main(String[] args) {
        String M[][] = {
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "1", "0"},
                {"0", "0", "0", "0", "0"}
        };
        int count = numIslands(M);
        System.out.println(count);
    }

    public static int numIslands(String[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == "1") {
                    maxArea = Math.max(maxArea, DFS(grid, i, j, 1));
                    ++count;
                }
            }
        }
        System.out.println(maxArea);

        return count;
    }

    public static int DFS(String[][] grid, int row, int col, int sum) {
        int rowDiff[]
                = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colDiff[]
                = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        grid[row][col] = "2";
        for (int i = 0; i < 8; i++) {
            if (canVisit(grid, row + rowDiff[i], col + colDiff[i])) {
                sum = DFS(grid, row + rowDiff[i], col + colDiff[i], sum + 1);
            }
        }
        return sum;
    }

    private static boolean canVisit(String[][] grid, int row, int col) {
        if (row >= 0 && row < 5 && col >= 0 && col < 5 && grid[row][col] == "1") {
            return true;
        }
        return false;
    }


}
