package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SmartAnagram {

    private static boolean isAnagram(String s1, String s2) {

        String [] arr1 =  s1.toLowerCase().split(" ");
        String fullString1="";
        for(String s : arr1) {
            fullString1= fullString1.concat(s);
        }
        //System.out.println(fullString1);

        String [] arr2 = s2.toLowerCase().split(" ");
        String fullString2="";
        for(String s : arr2) {
            fullString2= fullString2.concat(s);
        }

        if(!fullString1.matches("^[a-zA-Z]*$") || !fullString2.matches("^[a-zA-Z]*$")) {
            return false;
        }
        //System.out.println(fullString2);
        char[] charArr1 = fullString1.toCharArray();
        char[] charArr2 = fullString2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return Arrays.toString(charArr1).equals(Arrays.toString(charArr2));


    }
    public static void main(String[] args) {
        System.out.println(isAnagram("Debit card", "bad credit"));
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String Input = sc.next();
//            if(Input.equals("Q")) {
//                break;
//            }
//            System.out.println(Input);
//        }



    }
}
