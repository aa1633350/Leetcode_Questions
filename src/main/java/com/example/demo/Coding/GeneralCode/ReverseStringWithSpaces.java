package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStringWithSpaces {

    public static String reverseWords(String s) {

        s = s.trim();
        List<String> list = Arrays.stream(s.split(" ")).filter(str -> !str.equals("")).collect(Collectors.toList());
        String [] arr = list.toArray(new String[0]);
        int i=0,j= arr.length-1;

        while(i<j) {
            // String front = arr[i];
            // String back = arr[j];

            String temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(String str : arr) {
            if(count<arr.length-1) {
                sb.append(str).append(" ");
            } else {
                sb.append(str);
            }
            count++;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
