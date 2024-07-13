package com.intertuma.algorithms.leetcode.week2;

import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        for(int i = 0; i < stones.length; i++)
            maxHeap.add(stones[i]);

        while(maxHeap.size() > 1){
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            if(s1 != s2){
                maxHeap.add(s1 < s2?s2-s1:s1-s2);
            }
        }

        if(maxHeap.isEmpty())
            return 0;
        else
            return maxHeap.poll();
    }
}
