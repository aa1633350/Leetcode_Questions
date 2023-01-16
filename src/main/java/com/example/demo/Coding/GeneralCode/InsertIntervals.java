package com.example.demo.Coding.GeneralCode;

import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {


        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int startIdx = 0;
        boolean liesInStart = false, liesInEnd = false;
        List<List<Integer>> ans = new LinkedList<>();
        int counter = 0;
        for(int [] i : intervals) {

            if(newStart >= i[0] && newStart<=i[1] && !liesInStart) {
                startIdx = counter;
                newStart = Math.min(newStart, i[0]);
                liesInStart = true;
            }

            if(newEnd >= i[0] && newEnd<=i[1] && !liesInEnd) {
                newEnd = Math.max(newEnd, i[1]);
                liesInEnd = true;
            }

            if(!liesInStart && !liesInEnd && newStart > i[1]) {
                startIdx = counter+1;
            }


            if(newStart>i[1] || newEnd < i[0]) {
                List<Integer> tempList = new LinkedList<>();
                tempList.add(i[0]);
                tempList.add(i[1]);
                ans.add(tempList);
            }

            counter++;
        }

        // if(liesInStart && liesInEnd) {
        List<Integer> tempList = new LinkedList<>();
        tempList.add(newStart);
        tempList.add(newEnd);
        ans.add(startIdx, tempList);
        //}

        return ans.stream().map(u -> u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }
}
