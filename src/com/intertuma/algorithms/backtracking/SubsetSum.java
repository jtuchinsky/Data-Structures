package com.intertuma.algorithms.backtracking;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SubsetSum {
    boolean subsetSum(int[] X, int T, int currentIndex){
        if(T==0) return true;
        if(T < 0 || currentIndex == 0) return false;

        return
                subsetSum(X, T-X[currentIndex], currentIndex - 1) ||
                subsetSum(X, T, currentIndex-1);
    }

    @Test
    public void subsetSum(){
        int[][] X = {
                {8,6,7,5,3,10,9},
                {11, 6, 5, 1, 7, 13, 12}
        };

        assertTrue(subsetSum(X[0], 15, X[0].length-1));
        assertFalse(subsetSum(X[1], 15, X[1].length-1));
    }

    Set<Integer> constructSum(int[] X, int T, int currentIndex){
        if(T==0) return new HashSet<>();
        if(T < 0 || currentIndex == 0) return null;

        Set<Integer> result = constructSum(X, T, currentIndex - 1);
        if(result != null)
            return result;

        result = constructSum(X, T - X[currentIndex], currentIndex - 1);
        if (result != null) {
            result.add(X[currentIndex]);
            return result;
        }
        return null;
    }

    @Test
    public void constructSum(){
        int[][] X = {
                {8,6,7,5,3,10,9},
                {11, 6, 5, 1, 7, 13, 12}
        };
        Set<Integer> result = constructSum(X[0], 15, X[0].length-1);
        assertNotNull(result);
        System.out.println(result);

        result = constructSum(X[1], 15, X[0].length-1);
        assertNull(result);
    }

}
