package com.example.demo.Coding.GeneralCode;

public class MinTimeToMakeRopeColorful {

    public static int minCost(String colors, int[] neededTime) {

        char [] ballons = colors.toCharArray();
        int time = 0;
        for(int i=0,j=1;i<ballons.length && j<ballons.length;) {

            if(ballons[i]==ballons[j]) {
                int time1 = neededTime[i];
                int time2 = neededTime[j];
                int minTime = Math.min(time1,time2);
                time+=minTime;
                if(time1 == time2) {
                    ballons[j] = '0';
                    j++;
                    continue;
                }

                if(minTime == time1) {
                    ballons[i]='0';
                    i=j;

                } else {
                    ballons[j] = '0';
                }
            }
            j++;
        }
        return time;
    }

    public static void main(String[] args) {
        int [] cost = {1,1,4,1,4,1};
        System.out.println(minCost("aaaaaa",cost));
    }
}
