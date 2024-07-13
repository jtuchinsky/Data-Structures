package com.intertuma.algorithms.leetcode.week3;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid.
 *
 * We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // Stack keeps positions of open brackets
        Stack<Integer> open = new Stack<>();
        // Stack keeps positions for stars
        Stack<Integer> star = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);

            if(c == '(')
                open.push(i);
            else if(c == '*'){
                star.push(i);
            } else {
                if(!open.empty())
                    open.pop();
                else if(!star.empty())
                    star.pop();
                else
                    return false;
            }
        }

        while(!open.empty()){
            if(star.empty())
                return false;
            else if(open.peek() < star.peek()){
                open.pop();
                star.pop();
            } else
                return false;
        }
        return true;
    }


    @Test
    public void checkValidString(){
        System.out.println(checkValidString("((*()*)"));
        System.out.println(checkValidString("((*()*))"));
        System.out.println(checkValidString("(*()*)"));
        System.out.println(checkValidString("((*()*))((*()*)"));
        System.out.println(checkValidString("(*()()())**(())"));
        System.out.println(checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
        System.out.println(checkValidString("("));
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
    }
}
