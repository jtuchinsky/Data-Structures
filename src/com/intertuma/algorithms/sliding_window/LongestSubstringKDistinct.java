package com.intertuma.algorithms.sliding_window;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int maxLen = 0, start = 0;
        HashMap<Character, Integer> cache = new HashMap<>();

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);
            // add the next character of the string to the Map
            cache.put(rightChar, cache.getOrDefault(rightChar, 0) + 1);

            // shrink the window while number of distinct characters > K
            while(cache.size() > k){
                char leftChar = str.charAt(start);

                if(cache.get(leftChar) == 1)
                    cache.remove(leftChar);
                else
                    cache.put(leftChar, cache.get(leftChar) - 1);

                start++;
            }
            // At this point number of distinct characters <= K
            maxLen = Integer.max(maxLen, end - start +1);
        }

        return maxLen;
    }

    @Test
    public void findLength(){
        int[] numChars = {2, 1, 3};
        String[] str = {"araaci", "araaci", "cbbebi"};
        int[] result = {4, 2, 5};

        for (int i = 0; i < 3; i++) {
            assertEquals(result[i], findLength(str[i], numChars[i]));
        }
    }
}
