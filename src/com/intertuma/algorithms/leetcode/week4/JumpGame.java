package com.intertuma.algorithms.leetcode.week4;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index
 * of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        return canJumpGreedy(nums);
    }

    private boolean canJumpGreedy(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return true;

        int leftmostGoodIndex = len - 1;

        for(int i = len - 1; i >= 0; i--){
            if (i + nums[i] >= leftmostGoodIndex) // we can jump from current position to leftmostGoodIndex
                leftmostGoodIndex = i;
        }
        return leftmostGoodIndex == 0;
    }

}
