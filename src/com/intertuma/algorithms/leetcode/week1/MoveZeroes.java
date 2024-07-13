package com.intertuma.algorithms.leetcode.week1;

import org.junit.Test;

import java.util.Arrays;

//Given an array nums, write a function to move all 0's to the end of it
// while maintaining the relative order of the non-zero elements.
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int read = 0, write = 0;

        while(read < nums.length){
            nums[write] = nums[read];
            if(nums[read] != 0) {
                write++;
            }
            read++;
        }

        while(write < nums.length){
            nums[write++] = 0;
        }
        //System.out.println(read + ", " + write);
    }

    @Test
    public void moveZeroes(){
        int[] nums = {1,2,0,3,0,0,4};
        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
