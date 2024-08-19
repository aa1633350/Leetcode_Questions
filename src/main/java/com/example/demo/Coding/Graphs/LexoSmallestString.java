package com.example.demo.Coding.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LexoSmallestString {

    private static void union(char [] parent, char ch1, char ch2) {
        if(ch1==parent[ch2-'a']) {
            return;
        }
        if(ch1-'a' > ch2-'a') { // ch2 c ch1 r

            if(parent[ch1-'a'] != ch1 && parent[ch1-'a'] > ch2-'a') {
                union(parent,ch2,parent[ch1-'a']);
            } else {
                parent[ch1-'a'] = ch2;
                union(parent,ch2,parent[ch1-'a']);
            }
            // if(parent[ch1-'a'] != ch1) {
            //     union(parent,ch2,parent[ch1-'a']);
            // }
            //parent[ch1-'a'] = ch2;
            //union(parent,ch2,parent[ch2-'a']);
        } else {
             if(parent[ch2-'a'] != ch2 && parent[ch2-'a'] > ch1-'a') {
                 union(parent,ch1,parent[ch2-'a']);
             } else {
                 parent[ch2-'a'] = ch1;
                 union(parent,ch1,parent[ch2-'a']);
             }
            //parent[ch2-'a'] = ch1;
            //union(parent,ch1,parent[ch1-'a']);

        }
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {


        int n = s1.length();
        char [] parent = new char [26];

        for(int i=0;i<26;i++) {
            int val = 97 + i;
            parent[i] = (char) val;
        }

        for(int i=0;i<n;i++) {
            char ch1 = s1.charAt(i); // o
            char ch2 = s2.charAt(i); // a

            union(parent,ch1,ch2);
        }

        for(int i=0;i<26;i++) {
            int val = 97 + i;
            if((char)val != parent[i]) {
                System.out.println((char)val + " -> " +parent[i]);
            }

        }

        return find(parent, baseStr);
        //return "xxx";
    }

    private static String find(char [] parent, String base) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<base.length();i++) {
            char child = base.charAt(i);
            char p = parent[child-'a'];
            while(child != p) {
                child = p;
                p =  parent[p-'a'];
            }
            sb.append(p);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String s1 = "programs";
        String s2 = "leetcode";
        String base = "sourcecode";
        System.out.println(smallestEquivalentString(s1,s2,base));

        List<List<Integer>> ans = new LinkedList<>();
        ans.add(1,new LinkedList<>());
        //ans.add(1, Arrays.asList(new int[]{1, 1}));
        int [][] val  =  ans.stream().map(u  -> u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }
}
