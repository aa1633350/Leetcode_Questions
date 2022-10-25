package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAListOfString {

    private static String sortListOfString(List<String> str) {

        StringBuilder msg = new StringBuilder();
        msg.append("hi").append("\n");
        //msg.append("worked?");
        String s= "snapshot";
        int i = Math.max(1,1);
        System.out.println(i);
        return msg.toString();
        //Collections.sort(str);
//        for (String s : str) {
//            char [] tempArr = s.toCharArray();
//            Arrays.sort(tempArr);
//            String x = new String(tempArr);
//            System.out.println(x);
//        }
    }
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("badeg");
        arr.add("ditysa");
        arr.add("lodwcz");
        arr.add("yfaqj");
        arr.add("ca");
        System.out.println(sortListOfString(arr));
    }
}
