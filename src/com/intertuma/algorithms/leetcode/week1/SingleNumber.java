package com.intertuma.algorithms.leetcode.week1;

import org.junit.Test;

import java.util.Arrays;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
public class SingleNumber {
    public int singleNumber(int[] nums){
        Arrays.sort(nums);

        int i = 1;
        while( i < nums.length){
            if(nums[i] == nums[i-1])
                i = i+2;
            else
                break;
        }

        return nums[i-1];

    }

    @Test
    public void singleNumber(){
        int[] arr1 = {1,2,1};
        int[] arr2 = {1,2,2};
        int[] arr3 = {1,2,3,3,1};

        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
        System.out.println(singleNumber(arr3));
    }
}
