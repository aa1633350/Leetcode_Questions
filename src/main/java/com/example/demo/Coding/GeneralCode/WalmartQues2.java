package com.example.demo.Coding.GeneralCode;

public class WalmartQues2 {

    // stock prices -> [8,5,3,7,2,8,1,3]


    private static int maxProfit(int [] prices) {
        int l=0,r=1,profit=0;

        while(r<prices.length) {
            if(prices[r] >= prices[l]) {
                profit = Math.max(prices[r]-prices[l], profit);
                r++;
            } else {
                l=r;
                r++;

            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int [] prices = {8,5,3,7,2,8,1,11,15};
        System.out.println("max profit : " + maxProfit(prices));
    }


}
