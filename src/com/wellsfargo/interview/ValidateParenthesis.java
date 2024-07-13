package com.wellsfargo.interview;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateParenthesis {
    char[] opening = {'(', '[', '{'};
    char[] closing = {')', ']', '}'};

    public boolean isValid(String s){

        Stack<Character> stack  = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isOpen(c) != -1)
                stack.push(c);
            else {
                int closeIndex = isClose(c);

                if(stack.empty())
                    return false;
                else {
                    if(stack.peek() != opening[closeIndex]){
                        return false;
                    } else
                        stack.pop();
                }
            }
        }

        return stack.empty();
    }

    int isClose(char c) {
        int result = -1;
        for(int i = 0; i < 3; i++){
            if(c == closing[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    int isOpen(char c) {
        int result = -1;
        for(int i = 0; i < 3; i++){
            if(c == opening[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Test
    public void isValid(){
        assertTrue(isValid("([{}])"));
        assertTrue(isValid("()()()"));
        assertFalse(isValid(")()()()"));
        assertFalse(isValid("()()())"));
        assertFalse(isValid("()()()]"));
        assertFalse(isValid("([{])"));
    }
}
