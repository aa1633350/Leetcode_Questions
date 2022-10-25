package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level+=1;
            while(size-- > 0) {
                String s = q.poll();
                for(int i=0;i<s.length();i++) {
                    String copy_s = s;
                    for(char newChar = 'a'; newChar<='z';newChar++) {

                        copy_s = s.substring(0,i) + newChar + s.substring(i+1);
                        if(s.equals(copy_s)) {
                            continue;
                        }
                        if(copy_s.equals(endWord)){
                            return level+1;

                        }
                        if(wordList.contains(copy_s)) {
                            wordList.remove(copy_s);
                            q.add(copy_s);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String begin = "leet";
        String end = "code";
        char ch = begin.charAt(2);
        end = end + ch + begin;
        System.out.println(end);
        List<String> list = new ArrayList<>();
        list.add("lest");
        list.add("leet");
        list.add("lose");
        list.add("code");
        list.add("lode");
        list.add("robe");
        list.add("lost");
        //System.out.println(ladderLength(begin,end,list));
    }
}
