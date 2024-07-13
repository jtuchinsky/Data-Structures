package com.intertuma.algorithms.leetcode.week3;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;

        int R = grid.length, C = grid[0].length;

        int dp[][] = new int[R][C];
        dp[0][0] = grid[0][0];

        for(int r = 1; r < R; r++){
            dp[r][0] = dp[r-1][0] + grid[r][0];
        }

        for(int c = 1; c < C; c++){
            dp[0][c] = dp[0][c-1] + grid[0][c];
        }

        for(int r = 1; r < R; r++){
            for(int c = 1; c < C; c++){
                dp[r][c] = Integer.min(dp[r-1][c], dp[r][c-1]) + grid[r][c];
            }
        }

        return dp[R-1][C-1];
    }
}
