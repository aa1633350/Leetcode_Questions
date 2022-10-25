package com.example.demo.Coding.Recursion;

import java.io.*;
import java.util.*;

public class AllCombinationOfIdenticalItemsInBoxes {

    public static int combinations(int cb, int tb, int ssf, int ti, String asf) {
        if(cb>tb){
            if (ssf==tb) {
                return 1;
            }
            return 0;
        }


       return  combinations(cb + 1, tb, ssf + 1, ti, asf + "+")+combinations(cb + 1, tb, ssf + 1, ti, asf + "-");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        System.out.println(combinations(1, nboxes, 0, ritems, ""));
    }

}

