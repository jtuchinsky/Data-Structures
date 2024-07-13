package com.wellsfargo.interview;

import org.junit.Test;

public class ValidParenthesis {
    public void printValidParenthesis(int n){
        printValidParenthesis("", n*2, 0, 0, 0);
    }

    void printValidParenthesis(String prefix, int n, int open, int close, int cur){
        if(cur == n)
            System.out.println(prefix);
        else {
            if(open == n/2)
                printValidParenthesis(prefix + ")", n, open , close + 1, cur + 1);
            else if(close == open)
                printValidParenthesis(prefix + "(", n, open + 1 , close, cur + 1);
            else {
                printValidParenthesis(prefix + ")", n, open , close + 1, cur + 1);
                printValidParenthesis(prefix + "(", n, open + 1 , close, cur + 1);
            }
        }
    }

    @Test
    public void printValidParenthesis(){
        printValidParenthesis(3);
    }
}
