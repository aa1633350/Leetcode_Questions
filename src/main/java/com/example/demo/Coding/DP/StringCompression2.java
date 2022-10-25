package com.example.demo.Coding.DP;

import java.util.Arrays;

public class StringCompression2 {

    public static void getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        String [][] mapping = new String [len][2];
        int count = 1,j=0;
        String sb = "";
        for(int i=1;i<len;i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                count++;
            } else {
                sb = Character.toString(s.charAt(i-1));
                mapping[j][0] = sb;
                mapping[j][1] = Integer.toString(count);
                j++;
                count = 1;
            }
        }
        mapping[j][0] = Character.toString(s.charAt(len-1));
        mapping[j][1] = Integer.toString(count);

        Arrays.sort(mapping, (String [] m1 , String [] m2) -> {
            if(m1[0] != null && Integer.parseInt(m2[1]) > Integer.parseInt(m1[1])) {
                return -1;
            } return 0;
        });
        for(String [] map : mapping ) {
            System.out.println(map[0] + " " + map[1]);
        }
    }

    public static void main(String[] args) {
        getLengthOfOptimalCompression("bbbbbbbcccdbb",2);

        StringBuilder sb = new StringBuilder();
        sb.length();
        sb.toString().toCharArray();
    }
}
