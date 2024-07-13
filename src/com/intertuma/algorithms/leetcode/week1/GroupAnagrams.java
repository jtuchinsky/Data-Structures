package com.intertuma.algorithms.leetcode.week1;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, LinkedList<Integer>> cache = new HashMap<>();
        List<List<String>> result = new LinkedList<>();

        int position = 0;
        for(String s : strs){
            String sorted = sortStr(s);
            cache.computeIfAbsent(sorted, key -> new LinkedList<Integer>()).add(position);
            position++;
        }

        Collection<LinkedList<Integer>> values = cache.values();
        for(LinkedList<Integer> positions : values){
            LinkedList<String> l = new LinkedList<>();
            for(Integer pos : positions){
                l.add(strs[pos]);
            }
            result.add(l);
        }

        return result;
    }

    String sortStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
