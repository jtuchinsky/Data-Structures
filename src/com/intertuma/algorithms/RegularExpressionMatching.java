package com.intertuma.algorithms;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching
 * with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return isMatch(s, p, 0, 0, dp);
    }

    boolean isMatch(String s, String p, int sPos, int pPos, Map<String, Boolean> dp) {
        String key = sPos + "|" + pPos;
        if (pPos == p.length()) {
            return sPos == s.length();
        } else if (sPos == s.length()) {
            while (pPos < p.length()) {
                if (p.charAt(pPos) != '*') {
                    return false;
                }
                pPos++;
            }
            return true;
        }
        if (!dp.containsKey(key)) {
            if (p.charAt(pPos) == '.' || p.charAt(pPos) == s.charAt(sPos)) {
                dp.put(key, isMatch(s, p, sPos + 1, pPos + 1, dp));
            } else if (p.charAt(pPos) == '*') {
                if(p.charAt(pPos-1) != s.charAt(s.charAt(sPos)))
                    dp.put(key, isMatch(s, p, sPos, pPos + 1, dp));
                else {
                    sPos = sPos + 1;
                    while(sPos < s.length() && s.charAt(sPos) == s.charAt(sPos - 1))
                        sPos++;
                    dp.put(key, isMatch(s, p, sPos + 1, pPos, dp));
                }
            } else {
                dp.put(key, false);
            }
        }
        return dp.get(key);
    }

    @Test
    public void isMatch() {
        System.out.println(isMatch("aa", "c*a*"));
    }
}
