package com.example.demo.leetcode.test;

public class RatMazeProblem {

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int [][] solution={ { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } };
        int n = maze.length;
        System.out.println(solveMaze(maze,0,0,solution,n));
        extracted(solution, n);
        System.out.println("");
        extracted(maze,n);
    }

    private static void extracted(int[][] solution, int n) {
        for (int i = 0; i< n; i++)
        {
            for (int j = 0; j< n; j++)
            {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static boolean isValid(int x,int y,int[][] maze,int n)
{
    if(x>=0 && x<n && y>=0 && y<n && maze[x][y]==1)
    {
        return true;
    }
    return false;
}
    private static Boolean solveMaze(int[][] maze,int x,int y ,int[][] solution,int n)
    {
        if((x==n-1) &&  (y==n-1) && maze[x][y]==1)
        {
            solution[x][y]=1;
            return true;
        }

        if(isValid(x,y,maze,n))
        {
            if(solution[x][y]==1) {
               return false;
            }

            solution[x][y]=1;
            if(solveMaze(maze,x+1,y,solution,n))
            {
                return true;
            }
            if(solveMaze(maze,x,y+1,solution,n))
            {
                return true;
            }

            solution[x][y]=0;
            return false;

        }
        return false;


    }
}
