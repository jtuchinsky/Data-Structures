package com.intertuma.algorithms.leetcode.week4;

import org.junit.Test;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[][] dp = new int[t2.length + 1][t1.length + 1];

        for (int i = 1; i < t2.length + 1; i++) {
            for (int j = 1; j < t1.length + 1; j++) {
                if (t2[i-1] == t1[j-1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[t2.length][t1.length];
    }

    @Test
    public void longestCommonSubsequence() {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
