package com.intertuma.algorithms.leetcode.week2;

import org.junit.Test;

// Given two strings S and T, return if they are equal when both are typed into empty text editors.
// # means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
public class BackspaseStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        removeBackspace(s);
        removeBackspace(t);

        int si = 0, ti = 0;

        while(si < s.length && ti < t.length){
            if(s[si] != t[ti])
                return false;
            else if(s[si] == '#')
                return true;
            si++; ti++;
        }
        return true;
    }

    void removeBackspace(char[] arr){
        int w = 0;

        for(int r = 0; r < arr.length; r++){
            arr[w] = arr[r];
            if(arr[r] != '#') {
                w++;
            } else {
                if(w > 0) w--;
            }
        }

        while(w < arr.length)
            arr[w++] = '#';
    }

    @Test
    public void removeBackspace(){
        char[][] data = {
            {'a', '#', 'b'},
            {'#', 'a', 'b'},
            {'a', 'b', '#'},
            {'#', '#'}
        };

        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
            removeBackspace(data[i]);
            System.out.println(data[i]);
            System.out.println("______________");
        }
    }

    @Test
    public void backspaceCompare(){
        String[] S = {"ab#c", "ab##", "a##c", "a#c"};
        String[] T = {"ad#c", "c#d#", "#a#c", "b"};

        for(int i = 0; i < S.length; i++){
            System.out.println(S[i] + " == " + T[i] + " is " + backspaceCompare(S[i], T[i]));
        }
    }
}
