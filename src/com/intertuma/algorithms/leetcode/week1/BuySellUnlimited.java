package com.intertuma.algorithms.leetcode.week1;

import org.junit.Test;

public class BuySellUnlimited {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0;

        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] >= prices[sell])
                sell = i;
            else {
                profit += prices[sell] - prices[buy];
                buy = i;
                sell = i;
            }
            System.out.println(buy + ", " + sell + ", " + profit);
        }

        if(buy != sell)
            profit += prices[sell] - prices[buy];

        return profit;
    }

    @Test
    public void maxProfit(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int[] prices1 = {1,2,3,4,5};
        System.out.println(maxProfit(prices1));
    }
}
