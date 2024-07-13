package com.intertuma.algorithms.leetcode.week4;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

// Given an array of integers and an integer k,
// you need to find the total number of continuous subarrays whose sum equals to k.
public class SubarraySumEqualsK {
    public int subarraySum1(int[] arr, int sum) {
        int result = 0, currSum = 0;

        for(int i = 0; i < arr.length; i++){
            currSum = arr[i];
            if(currSum == sum)
                result++;
            for(int j = i+1; j<arr.length; j++){
                currSum += arr[j];
                if(currSum == sum)
                    result++;
            }
        }
        return result;
    }

    public int subarraySum(int[] arr, int sum) {
        // Key - sum, Value - count
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sumSoFar = 0, count = 0;

        for(int i = 0; i < arr.length; i++){
            sumSoFar += arr[i];
            if(map.containsKey(sumSoFar - sum)){
                count += map.get(sumSoFar - sum);
            }
            map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
            System.out.println(map);
        }
        return count;
    }

    @Test
    public void subarraySum(){
        assertEquals(2, subarraySum(new int[] {1,1,1}, 2));
        assertEquals(0, subarraySum(new int[] {1}, 0));
        assertEquals(1, subarraySum(new int[] {-1, -1, 1}, 0));
    }

}
