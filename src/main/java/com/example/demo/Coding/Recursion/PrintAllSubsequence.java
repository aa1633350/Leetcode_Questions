package com.example.demo.Coding.Recursion;

public class PrintAllSubsequence {


    public static void main(String[] args) {

        printAllSubsequence("yvTa", "");
    }

    private static void printAllSubsequence(String s, String ans) {
//        if(s.length()==1) {
//            return;
//        }
//        if(start==len) {
//            System.out.println(ans);
//            return;
//        }
        if(s.length()==0) {
            System.out.println(ans);
            return;
        }
        //System.out.println(ans);
//        char ch = s.charAt(0);
//        String remString = s.substring(1);
        //for(int i=start;i<s.length();i++) {
            printAllSubsequence(s.substring(1),ans+s.charAt(0));
            printAllSubsequence(s.substring(1),ans);

        //}

    }
}
