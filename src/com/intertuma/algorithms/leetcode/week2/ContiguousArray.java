package com.intertuma.algorithms.leetcode.week2;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    public int findMaxLengthBruteForce(int[] nums) {
        int sum = 0, result = 0;

        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                sum = (nums[i] == 0) ? -1 : 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == 0)
                        sum += -1;
                    else
                        sum += 1;

                    if (sum == 0) {
                        result = Integer.max(result, i - j + 1);
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void findMaxLengthBruteForce() {
        int[] nums = {1, 0, 0, 1, 0, 1, 1};
        assertEquals(6, findMaxLengthBruteForce(nums));
    }

    // Replace 0 with -1 in original array
    // Now we need to find max sub-array which sums to 0
    // We keep HashMap, containig the cumulative sum up to the current index
    // Sum(0..i) = Sum(0..j) + Sum(j+1..i), which means that
    // if Sum(0..i) (current sum) == Sum(0..j) (Stored in HashMap)
    // then Sum(j+1..i) == 0
    public int findMaxLength(int[] nums) {
        // Key - sum, Value - index
        HashMap<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when
        // sub-array with sum 0 starts from index 0
        map.put(0, -1);

        int sumSoFar = 0;

        int maxLen = 0;

        // Traverse array
        for (int i = 0; i < nums.length; i++) {
            //sum of elements so far, replacing 0 with -1
            sumSoFar += (nums[i] == 0) ? -1 : 1;

            //if sum seen before
            if (map.containsKey(sumSoFar)) {
                maxLen = Integer.max(maxLen, i - map.get(sumSoFar));
            } else {
                map.put(sumSoFar, i);
            }
        }
        return maxLen;
    }

    @Test
    public void findMaxLength() {
        int[] nums = {1, 0, 0, 1, 0, 1, 1};
        assertEquals(6, findMaxLength(nums));
    }

}