package com.example.demo.Coding.GeneralCode;

import java.util.Stack;

public class GoodString {

    public static String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        st.peek();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0;i<sb.length()-1;i++) {
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(i+1);
            if(Character.isUpperCase(ch1)) {

                if(Character.toLowerCase(ch1) == ch2) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }
            } else {
                if(Character.toUpperCase(ch1) == ch2) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        makeGood("aBbAcC");
    }
}
