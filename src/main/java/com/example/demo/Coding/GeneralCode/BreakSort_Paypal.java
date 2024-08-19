package com.example.demo.Coding.GeneralCode;

import com.example.demo.InterfaceCheck.B;

import java.util.Collections;
import java.util.PriorityQueue;

public class BreakSort_Paypal {

    private boolean isSorted(PriorityQueue<Integer> pq) {
        int prev = Integer.MIN_VALUE;
        for(int num : pq) {
            if(num < prev) {
                return false;
            }
            prev = num;
        }
        return true;
    }

    private int sortArrayByBreaking(int [] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : arr) {
            pq.add(a);
        }
        int operations=0;
        while(!isSorted(pq)) {
            int top = pq.poll();
            int half1 = top/2;
            int half2 = top - half1;

            pq.add(half1);
            pq.add(half2);
            operations++;
        }
        return operations;

    }

    public static void main(String[] args) {
        BreakSort_Paypal paypal = new BreakSort_Paypal();
        System.out.println("Operations " + paypal.sortArrayByBreaking(new int [] {3,4,3}));
    }
}
