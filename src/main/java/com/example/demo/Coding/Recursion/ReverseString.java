package com.example.demo.Coding.Recursion;

public class ReverseString {

    static String reverseString (String str, String ans, int i) {

        if(i<0) {
            //System.out.println(ans);
            return ans;
        }
        ans = ans.concat(String.valueOf(str.charAt(i)));
        return reverseString(str,ans,i-1);

    }
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(reverseString(str, "", str.length()-1));
    }
}
