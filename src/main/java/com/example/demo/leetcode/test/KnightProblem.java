package com.example.demo.leetcode.test;

import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

import javax.swing.text.StyledEditorKit;

public class KnightProblem {

    static int[] rowPath={2,1,-1,-2,-2,-1,2};
    static int[] colPath={1,2,2,1,-1,-2,-2,-1};

    private static Boolean  checkTour(int row, int col, int moves, int[][] visited)
    {
//        displayMatrix(visited);

        if(moves==64)
        {
            displayMatrix(visited);
            return true;
        }
        else {
            for(int index=0;index<rowPath.length;index++)
            {
                int newRow=row+rowPath[index];
                int newCol=col+colPath[index];
                if(isValidMove(visited,newRow,newCol))
                {
                    moves++;
                    visited[newRow][newCol]=moves;
                    if(checkTour(newRow,newCol,moves,visited))
                    {
                        return true;
                    }
                    moves--;
                    visited[newRow][newCol]=0;

//                    visited[newRow,newCol] = 0;

                }
            }
            return false;
        }


    }

    private static void displayMatrix(int[][] visited) {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static Boolean isValidMove(int[][] visited,int row,int col)
    {
        if((row>=0) && (row<8) && (col>=0) && (col<8) && visited[row][col]==0)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        matrix[0][0]=1;
        System.out.println(checkTour(0,0,1,matrix));
        displayMatrix(matrix);
    }
}
