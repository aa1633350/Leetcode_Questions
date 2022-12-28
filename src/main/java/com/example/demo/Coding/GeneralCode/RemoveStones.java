package com.example.demo.Coding.GeneralCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStones {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        for(int i : piles) {
            pq.add(i);
            sum+=i;
        }
        while(k-- > 0) {
            int top = pq.poll();
            int removedVal = (int)(Math.floor(top/2));
            top = top - removedVal;
            sum = sum - removedVal;
            pq.add(top);

        }
        return sum;
    }
}
