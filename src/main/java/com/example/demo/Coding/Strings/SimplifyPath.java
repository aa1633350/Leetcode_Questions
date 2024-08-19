package com.example.demo.Coding.Strings;

import java.util.regex.Pattern;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/";
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        String [] dirs = path.split("/");
        int count=0;
        for(String s : dirs) {
            count++;
            if(!s.equals("") && Pattern.matches("^[a-zA-Z]*$", s)){
                sb.append(s);
                if(count<dirs.length) {
                    sb.append("/");
                }

            }


        }

        System.out.println(sb);


    }
}
