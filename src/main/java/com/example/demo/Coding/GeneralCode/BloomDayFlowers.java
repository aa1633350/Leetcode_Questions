package com.example.demo.Coding.GeneralCode;

import java.util.LinkedList;
import java.util.List;

public class BloomDayFlowers {

    public static int minDays(int[] bloomDay, int m, int k) {

        int length = bloomDay.length, days=Integer.MAX_VALUE;
        if(m*k > length) {
            return -1;
        }

        int maxBloomDay = 0;
        for(int i : bloomDay) {
            maxBloomDay = Math.max(maxBloomDay,i);
        }

        int low=1,high=maxBloomDay;
        while(low<=high) {

            int mid = low + (high-low)/2;
            int bouquets = 0;
            boolean [] bloomedFlower = new boolean [length];
            for(int i=0;i<bloomDay.length;i++) {

                if(bloomDay[i] <= mid) {
                    bloomedFlower[i] = true;
                }
            }

            for(int i=0;i<=bloomedFlower.length-k;) {
                if(bloomedFlower[i]) {
                    int cnt=0;
                    for(int j=i;j<i+k;j++) {
                        if(bloomedFlower[j]) {
                            cnt++;
                        }
                    }
                    if(cnt==k) {
                        bouquets++;
                        i=i+k;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }

                if(bouquets == m) {
                    days = Math.min(days,mid);
                } else if(bouquets < m) {
                    // go right
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }

        }
        return days == Integer.MAX_VALUE ? -1 : days;
    }

    public static void main(String[] args) {
        int [] bloom = {1,10,3,10,2,1};
        System.out.println(minDays(bloom,2,2));
    }
}
