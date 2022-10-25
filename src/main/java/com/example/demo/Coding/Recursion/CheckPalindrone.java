package com.example.demo.Coding.Recursion;

public class CheckPalindrone {

    static boolean palindrone (String str, int i, int j) {

        if(i>j) {
            //System.out.println(ans);
            return true;
        }
        if(str.charAt(i)!=str.charAt(j)) {
            return false;
        }
        return palindrone(str,i+1,j-1);
    }
    public static void main(String[] args) {
        String str = "mom";
        System.out.println(palindrone(str, 0, str.length()-1));
    }
}
