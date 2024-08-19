package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.List;

public class SupportersDEShaw {
    private static long findWinner(List<Integer> supporters) {
        if(supporters.size()<=2) {
            int team1 = supporters.get(0);
            int team2 = supporters.get(1);

            return Math.max(team1, team2);
        }
        List<Integer> tempList = new ArrayList<>();
        for(int i=0;i<supporters.size();i+=4) {

            int win1,lose1,win2,lose2;

            int team1 = supporters.get(i);
            int team2 = supporters.get(i+1);
            int team3 = supporters.get(i+2);
            int team4 = supporters.get(i+3);

            if(team1>=team2) {
                win1 = team1;
                lose1 = team2;
            } else {
                win1 = team2;
                lose1 = team2;
            }

            if(team3>=team4) {
                win2 = team3;
                lose2 = team4;
            } else {
                win2 = team4;
                lose2 = team3;
            }


            tempList.add(win1+lose2);
            tempList.add(win2+lose1);
        }
        return findWinner(tempList);
    }

    public static void main(String[] args) {
        int [] arr = {4,6,2,3,4,3,2,1};
        List<Integer> list = new ArrayList<>();
        for(int i: arr) {
            list.add(i);
        }

        System.out.println(findWinner(list));
    }
}
