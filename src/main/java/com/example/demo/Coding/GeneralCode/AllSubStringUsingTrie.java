package com.example.demo.Coding.GeneralCode;

import java.util.HashSet;

class trienode {
    trienode[] child;
    boolean isEnd;

    trienode() {
        child = new trienode[26];
        isEnd = false;
    }
}
public class AllSubStringUsingTrie {
    public static void main(String[] args) {
        HashSet<String> uniqueString = new HashSet<>();
        String s = "abc";
        trienode root = new trienode();
        for(int i=0;i<s.length();i++) {
            trienode currNode = root;
            for(int j=i;j<s.length();j++) {
                char ch = s.charAt(j);
                if(currNode.child[ch-'a'] == null) {
                    currNode.child[ch-'a'] = new trienode();
                }
                currNode = currNode.child[ch-'a'];
                if(!currNode.isEnd) {
                    uniqueString.add(s.substring(i,j+1));
                    currNode.isEnd = true;
                }

            }
        }

        System.out.println(uniqueString);
    }


}