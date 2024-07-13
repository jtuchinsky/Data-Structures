package com.intertuma.algorithms.leetcode.week4;

import org.junit.Test;

import java.util.*;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 */

public class FirstUnique {
    private Set<Integer> cache= new LinkedHashSet<>();
    private Set<Integer> seen= new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for(int n : nums){
            add(n);
        }
    }

    public int showFirstUnique(){
        Iterator<Integer> it = cache.iterator();
        if(!it.hasNext())
            return -1;
        else
            return it.next();
    }

    public void add(int value){
        if(!seen.contains(value)){
            seen.add(value);
            cache.add(value);
        } else {
            cache.remove(value);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,2,3,1,2,3};

        FirstUnique fu = new FirstUnique(nums);
        System.out.println(fu.showFirstUnique());
        fu.add(1);
        fu.add(2);
        System.out.println(fu.showFirstUnique());

    }
}
