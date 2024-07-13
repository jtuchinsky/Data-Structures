package com.intertuma.algorithms.leetcode.week4;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 *
 * Approach
 * ==========
 *
 * In this problem, because the range is continuous, the only case that lowest bit will become 1 is
 * when m==n, and the lowest bit is 1.
 * In other words,  for the range [m, n], if n > m, the lowest bit is always 0.
 * Why? Because either the lowest bit of m is 0 or 1, the lowest bit of (m AND m+1) must be 0.
 *
 * Now we have get the lowest bit for final result, next step is to check the 2nd lowest bit.
 * How to do it? Just using bit shifting!  m >> 1 and n >> 1 is all we need.
 *
 * When to stop looping? Consider the case that:
 * m =  01000
 * n =   01011
 *
 * (1)   01011 > 01000  ->  lowest bit = 0
 * (2)   0101 > 0100    ->  2nd lowest bit  = 0
 * (3)   010 = 010      ->  3rd lowest bit = current lowest bit   0
 * (4)   01 = 01        ->  4th lowest bit = current lowest bit   1
 * (5)   0 = 0          ->  5th lowest bit = current lowest bit   0
 *
 * We can see that step (3)-(5) is unnecessary,
 * when m=n, the other bits are just the same as current m (or n).
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int pos = 0; // first common bit position
        while(true){
            if(n > m){
                pos++;
            } else {
                return m << pos;
            }
            m = m >> 1; // eliminate rightmost bit
            n = n >> 1; // eliminate rightmost bit
        }
    }

}
