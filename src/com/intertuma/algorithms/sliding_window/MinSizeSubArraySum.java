package com.intertuma.algorithms.sliding_window;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int minLen = Integer.MAX_VALUE, start = 0;

        int sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];   // add the next element in the array to the Sum

            while (sum >= S) { // shrink the window while sum >= S
                minLen = Integer.min(end - start + 1, minLen);
                sum -= arr[start]; // subtract element going out of the window
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    public void findMinSubArray(){
        int[] sum = {7, 7, 8};
        int[][] arr = {
                { 2, 1, 5, 2, 3, 2 },
                { 2, 1, 5, 2, 8 },
                { 3, 4, 1, 1, 6 }
        };
        int[] result = {2, 1, 3};

        for(int i = 1; i < 2; i++){
            assertEquals(result[i], findMinSubArray(sum[i], arr[i]));
        }
    }
}
