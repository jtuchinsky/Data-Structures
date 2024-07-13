package com.intertuma.algorithms.leetcode.string;

import org.junit.Test;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        str = str.replaceAll("[^A-Za-z0-9]", "");

        System.out.println(str);

        int l = 0, r = str.length()-1;

        while(l<r){
            if(str.charAt(l) != str.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }

    @Test
    public void isPalindrome(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
