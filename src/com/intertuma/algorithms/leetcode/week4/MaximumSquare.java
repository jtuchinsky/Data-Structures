package com.intertuma.algorithms.leetcode.week4;

import org.junit.Test;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)
            return 0;

        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++){
                if(matrix[0][i] == '1')
                    return 1;
            }
            return 0;
        }

        if(matrix[0].length == 1) {
            for(int i = 0; i < matrix.length; i++){
                if(matrix[i][0] == '1')
                    return 1;
            }
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        // copy the first row
        for(int i = 0; i < matrix[0].length; i++ )
            dp[0][i] = (int) (matrix[0][i] - 48);

        // copy the first column
        for(int i = 0; i < matrix.length; i++)
            dp[i][0] = (int) (matrix[i][0] - 48);

        //populate dp
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }

        // find max element in dp
        int maxSize = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }

    @Test
    public void maximalSquare(){
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println(maximalSquare(matrix));

        char[][] m = {{'0', '1'}};
        System.out.println(maximalSquare(m));

        System.out.println(maximalSquare(new char[][] {{}}));
        System.out.println(maximalSquare(new char[][] {}));
    }
}
