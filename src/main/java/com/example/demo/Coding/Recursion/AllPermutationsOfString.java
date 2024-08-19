package com.example.demo.Coding.Recursion;

public class AllPermutationsOfString {

    private static void generateAllPermutations(String s, boolean [] used, String ans) {

        if(ans.length() == s.length()) {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<s.length();i++) {
            if(!used[i]) {
                used[i]=true;
                generateAllPermutations(s,used,ans+s.charAt(i));
                used[i]=false;
            }
        }

    }

    public static void main(String[] args) {
        String s = "chat";
        boolean [] used = new boolean[s.length()];
        generateAllPermutations(s,used,"");
    }
}
