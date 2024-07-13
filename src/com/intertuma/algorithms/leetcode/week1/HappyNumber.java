package com.intertuma.algorithms.leetcode.week1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 *
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        int sum = calculateSum(n);

        while(sum != 1){
            if(visited.contains(sum))
                return false;
            visited.add(sum);
            sum = calculateSum(sum);
        }

        return true;
    }

    int calculateSum(int num){
        int sum = 0;

        while(num != 0){
            int reminder = num % 10;
            sum += reminder*reminder;
            num = num /10;
        }

        return sum;
    }

    @Test
    public void isHappy(){
        System.out.println(isHappy(1));
        System.out.println(isHappy(19));
    }
}
