package com.intertuma.algorithms.leetcode.week3;

import org.junit.Test;

public class FindFirstOneInSortedBinaryArray {
    public int findFirstOne(int[] arr){
        if(arr[0] == 1)
            return 0;
        if(arr[arr.length-1] == 0)
            return -1;

        int left=0, right=arr.length-1;

        return helper(arr, left, right);
    }

    private int helper(int[] arr, int left, int right) {
        int pos = -1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] == 1){
                pos = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return pos;
    }

    @Test
    public void findFirstOne(){
        System.out.println(findFirstOne(new int[] {0,1}));
        System.out.println(findFirstOne(new int[] {0,0,1}));
        System.out.println(findFirstOne(new int[] {0,1,1}));
    }
}
